package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.entity.User;
import yamazon.form.UserInsertForm;

@Controller
public class AccountInsertController {

	@RequestMapping(value = "/userInsert", method = RequestMethod.GET)
	public String userInsert(@ModelAttribute("yamazon")UserInsertForm form, Model model) {
		return "userInsert";
	}

	@RequestMapping(value = "/userInsertConfirm", method = RequestMethod.POST)
	public String userInsertConfirm(@ModelAttribute("yamazon") UserInsertForm form,HttpSession u_info, Model model) {

		String Un = form.getName();
		String T = form.getTel();
		String P = form.getPass();
		String A = form.getAddress();


		User user = new User(Un, T, P, A);

		u_info.setAttribute("a",user);
		return "userInsertConfirm";
	}

	@RequestMapping(value = "/userback", method = RequestMethod.GET)
	public String userback(@ModelAttribute("yamazon") UserInsertForm form, Model model) {
		return "userInsert";

	}
	@RequestMapping(value = "/userInsertResult", method = RequestMethod.POST)
	public String userInsertResult(@ModelAttribute("yamazon") UserInsertForm form, Model model, BindingResult bindingResult) {

		return "userInsertResult";
	}
}
