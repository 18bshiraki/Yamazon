package yamazon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.GoodsDao;
import yamazon.entity.Goods;
import yamazon.form.Search;

@Controller
public class CartControlle {
	@Autowired
	HttpSession session;


	@Autowired
	GoodsDao goods;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/Incart", method = RequestMethod.POST)
	public String Incart(@ModelAttribute("yamazon") Search search, Model model) {
		List<String> cart = new ArrayList<String>();
		List<Goods> good=new ArrayList<Goods>();
		//cart = (List<String>) session.getAttribute("cart");
		//String id = req.getParameter("getButtonValue");
		cart.add(search.getId());
		session.setAttribute("cart", cart);
		cart=(List<String>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			Integer id = Integer.valueOf(cart.get(i));
			good.addAll(goods.cart(id));
		}
		model.addAttribute("goods", good);

		return "cart";
	}
	@SuppressWarnings("unchecked")
	@PostMapping("/cartDel")
	public String del(@ModelAttribute("yamazon") Search search, Model model) {
		List<String> cart=new ArrayList<String>();
		cart=(List<String>) session.getAttribute("cart");
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).equals(search.getId())) {
				cart.remove(i);
			}
		}
		return "cart";
	}

}