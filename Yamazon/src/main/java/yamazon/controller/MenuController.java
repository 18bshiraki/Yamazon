package yamazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
	@RequestMapping(value =  "/menu" , method = RequestMethod.GET)
	public String menu(Model model) {
		return "menu";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
		return "account";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(Model model) {
		return "cart";
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
