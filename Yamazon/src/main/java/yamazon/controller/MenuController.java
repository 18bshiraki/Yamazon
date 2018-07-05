package yamazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.form.GoodsForm;

@Controller
public class MenuController {
	@RequestMapping(value = { "/", "/menu" }, method = RequestMethod.GET)
	public String menu(Model model) {
		return "managerMenu";
	}

	@RequestMapping(value = "/goodsInsert", method = RequestMethod.GET)
	public String goodsInsert(@ModelAttribute("yamazon")GoodsForm form, Model model) {
		return "goodsInsert";
	}

	@RequestMapping(value = "/goodsSearch", method = RequestMethod.GET)
	public String cart(@ModelAttribute("yamazon")GoodsForm form, Model model) {
		return "goodsSearch";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "logout";
	}


}
