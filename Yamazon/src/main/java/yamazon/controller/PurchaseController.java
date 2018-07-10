package yamazon.controller;

import java.text.NumberFormat;
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
		if (session.getAttribute("cart") != null) {
			cart = (List<String>) session.getAttribute("cart");
		}
		if (cart.isEmpty()) {
			model.addAttribute("msg", "カートに商品を入れてください");
			return "cart";
		}
		//List<String> cart = new ArrayList<String>();

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
		for (int i = 0; i < good.size(); i++) {
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			//good.get(i).setCPrice(nfCur.format(good.get(i).getPrice()));
			good.get(i).setCTaxPrice(nfCur.format(good.get(i).getTaxPrice()));
		}
		if (sum >= 50000) {
			int sum5 = (int) (sum * 0.95);
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();

			model.addAttribute("sum5", nfCur.format(sum5));
		}
		NumberFormat nfCur = NumberFormat.getCurrencyInstance();
		model.addAttribute("goods", good);
		model.addAttribute("sum", nfCur.format(sum));

		return "purchase";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/buy")
	public String buy(@ModelAttribute("yamazon") Search form, Model model) {
		List<String> cart = new ArrayList<String>();
		cart = (List<String>) session.getAttribute("cart");
		List<Goods> good = new ArrayList<Goods>();
		List<String> errMsg = new ArrayList<String>();
		int sum = 0;
		int sum5 = 0;
		if (!form.getWord().equals("")) {
			cart = new ArrayList<String>();
			if (session.getAttribute("cart") != null) {
				cart = (List<String>) session.getAttribute("cart");
			}
			good = new ArrayList<Goods>();
			for (int i = 0; i < cart.size(); i++) {
				Integer id = Integer.valueOf(cart.get(i));
				good.addAll(goods.cart(id));
			}
			for (int i = 0; i < good.size(); i++) {
				NumberFormat nfCur = NumberFormat.getCurrencyInstance();
				//good.get(i).setCPrice(nfCur.format(good.get(i).getPrice()));
				good.get(i).setCTaxPrice(nfCur.format(good.get(i).getTaxPrice()));
			}
			model.addAttribute("goods", good);
			return "cart";
		}
		for (int i = 0; i < cart.size(); i++) {
			Integer id = Integer.valueOf(cart.get(i));
			good.addAll(goods.cart(id));
		}
		for (int i = 0; i < good.size(); i++) {
			if (good.get(i).getStock() <= 0) {
				//List<String> errMsg=new ArrayList<String>();
				errMsg.add("ごめんなさい！" + good.get(i).getGoodsName() + "は売り切れです!");
				//good.remove(i);
				good.get(i).setGoodsName("ごめんなさい！" + good.get(i).getGoodsName() + "は売り切れです!");
				List<String> carts = new ArrayList<>();
				carts.add(String.valueOf(good.get(i).getGoodsNumber()));
				//Collections.addAll(carts, String.valueOf(good.get(i).getGoodsNumber()));
				cart.removeAll(carts);
			}
		}

		for (int i = 0; i < good.size(); i++) {
			int price = good.get(i).getTaxPrice();
			if (good.get(i).getStock() > 0) {
				sum = sum + price;
			}
		}
		if (sum >= 50000) {
			sum5 = (int) (sum * 0.95);
		}
		if (!errMsg.isEmpty()) {
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			for (int i = 0; i < good.size(); i++) {
				//NumberFormat nfCur = NumberFormat.getCurrencyInstance();
				//good.get(i).setCPrice(nfCur.format(good.get(i).getPrice()));
				good.get(i).setCTaxPrice(nfCur.format(good.get(i).getTaxPrice()));
			}
			//model.addAttribute("errMsg", errMsg);
			session.setAttribute("cart", cart);
			model.addAttribute("word", "word");
			model.addAttribute("sum5", nfCur.format(sum5));
			model.addAttribute("sum", nfCur.format(sum));
			model.addAttribute("goods", good);
			return "purchase";
		}
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss　(E)");
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