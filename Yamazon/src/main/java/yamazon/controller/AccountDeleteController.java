package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.UserDao;
import yamazon.entity.User;
import yamazon.form.UserInsertForm;

@Controller
public class AccountDeleteController {
	@Autowired
	UserDao Delete;
    @Autowired
    HttpSession session;

	@RequestMapping(value = "/accountDeleteResult", method = RequestMethod.POST)
	public String accountDeleteResult(@ModelAttribute("yamazon")UserInsertForm form, Model model) {

		User user = (User) session.getAttribute("user");
		String tel = user.getPhoneNumber();
		String pass = user.getPassword();

		Delete.userDelete(tel,pass);
		session.removeAttribute("user");

		return "accountDeleteResult";
	}
}
