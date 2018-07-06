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
public class AccountUpdateController {
	@Autowired
	UserDao upd;
    @Autowired
    HttpSession session;

	@RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
	public String accountUpdate(@ModelAttribute("yamazon")UserInsertForm form,HttpSession u_info, Model model) {

		String name = form.getName();
		String tel = form.getTel();
		String pass = form.getPass();
		String address = form.getAddress();

		u_info.setAttribute("tell",tel);
		u_info.setAttribute("name",name);
		u_info.setAttribute("pass",pass);
		u_info.setAttribute("address",address);

		return "accountUpdateConfirm";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String account(@ModelAttribute("yamazon")UserInsertForm form,HttpSession u_info, Model model) {
		return "account";

	}

	@RequestMapping(value = "/accountUpdateConfirm", method = RequestMethod.POST)
	public String accountUpdateConfirm(@ModelAttribute("yamazon")UserInsertForm form,HttpSession u_info, Model model) {

		User user = (User) session.getAttribute("user");

		String Un = form.getName();
		String T = form.getTel();
		String P = form.getPass();
		String A = form.getAddress();
		String N = user.getPhoneNumber();

		User users = new User(T,Un,A,P);

		session.setAttribute("users", users);

		upd.userUpdate(T,Un,A,P,N);

		return "accountUpdateResult";
	}
}

