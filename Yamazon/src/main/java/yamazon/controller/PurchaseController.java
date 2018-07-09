package yamazon.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.GoodsDao;
import yamazon.dao.PurchaseDao;
import yamazon.entity.Goods;
import yamazon.entity.User;
import yamazon.form.Search;

@Controller
public class PurchaseController {
	@Autowired
	GoodsDao goods;
	@Autowired
	PurchaseDao pur;
	@Autowired
	HttpSession session;

	@SuppressWarnings("unchecked")
	@PostMapping("/purchase")
	public String purchase(@ModelAttribute("yamazon") Search form, Model model) {
		List<String> cart = new ArrayList<String>();
		cart = (List<String>) session.getAttribute("cart");
		List<Goods> good = new ArrayList<Goods>();
		for (int i = 0; i < cart.size(); i++) {
			Integer id = Integer.valueOf(cart.get(i));
			good.addAll(goods.cart(id));
		}
		int sum = 0;
		//List<Integer> summ = new ArrayList<Integer>();
		for (int i = 0; i < good.size(); i++) {
			int price = good.get(i).getTaxPrice();
			sum = sum + price;
		}
		if (sum >= 50000) {
			int sum5 = (int) (sum * 0.95);
			model.addAttribute("sum5", sum5);
		}
		model.addAttribute("goods", good);
		model.addAttribute("sum", sum);

		return "purchase";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/buy")
	public String buy(@ModelAttribute("yamazon") Search form, Model model) {
		List<String> cart = new ArrayList<String>();
		cart = (List<String>) session.getAttribute("cart");
		List<Goods> good = new ArrayList<Goods>();
		List<String> errMsg = new ArrayList<String>();
		for (int i = 0; i < cart.size(); i++) {
			Integer id = Integer.valueOf(cart.get(i));
			good.addAll(goods.cart(id));
		}
		for (int i = 0; i < good.size(); i++) {
			if (good.get(i).getStock() == 0) {
				//List<String> errMsg=new ArrayList<String>();
				errMsg.add("ごめんなさい！" + good.get(i).getGoodsName() + "は売り切れです!");
				//good.remove(i);
				good.get(i).setGoodsName("ごめんなさい！" + good.get(i).getGoodsName() + "は売り切れです!");
				cart.remove(i);
			}

		}
		if (!errMsg.isEmpty()) {
			//model.addAttribute("errMsg", errMsg);
			session.setAttribute("cart",cart);
			model.addAttribute("goods", good);
			return "purchase";
		}
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss　E");
		String day = df1.format(d);
		User user = (User) session.getAttribute("user");
		for (int i = 0; i < good.size(); i++) {
			pur.history(user.getUserId(), good.get(i).getGoodsName(), good.get(i).getTaxPrice(), day);
			pur.stock(good.get(i).getStock() - 1, good.get(i).getGoodsName());
		}
		session.removeAttribute("cart");

		return "purchaseResult";
	}
}