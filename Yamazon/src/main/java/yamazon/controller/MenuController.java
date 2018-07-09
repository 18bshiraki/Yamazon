package yamazon.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.GoodsDao;
import yamazon.entity.Goods;
import yamazon.form.LoginForm;
import yamazon.form.Search;

@Controller
public class MenuController {

	@Autowired
	HttpSession session;

	@Autowired
	GoodsDao goodsDao;

	@RequestMapping(value = { "/", "/menu" }, method = RequestMethod.GET)
	public String menu(@ModelAttribute("yamazon")Search form, Model model) {
		session.removeAttribute("manager");
		List<Goods> goods = goodsDao.goodsMenu();
		model.addAttribute("list", goods);

		return "menu";
	}
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
		return "account";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(@ModelAttribute("yamazon") Search search, Model model) {
		List<String> cart = new ArrayList<String>();
		cart = (List<String>) session.getAttribute("cart");
		List<Goods> good = new ArrayList<Goods>();
		for (int i = 0; i < cart.size(); i++) {
			Integer id = Integer.valueOf(cart.get(i));
			good.addAll(goodsDao.cart(id));
		}
		model.addAttribute("goods",good);
		return "cart";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("yamazon")LoginForm form,Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}


}
