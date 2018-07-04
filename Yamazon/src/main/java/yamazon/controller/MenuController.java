package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.form.LoginForm;
import yamazon.form.Search;

@Controller
public class MenuController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = { "/", "/menu" }, method = RequestMethod.GET)
	public String menu(@ModelAttribute("yamazon")Search form,Model model) {
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
	public String login(@ModelAttribute("yamazon")LoginForm form,Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "logout";
	}


}
