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
	public String accountUpdate(@ModelAttribute("yamazon") UserInsertForm form, HttpSession u_info, Model model) {

		String name = form.getName();
		String tel = form.getTel();
		String pass = form.getPass();
		String address = form.getAddress();
		String newPass = form.getNewpass();
		User user = (User) session.getAttribute("user");
		if (11 < form.getTel().length() || form.getTel().length() < 10) {
			model.addAttribute("msg", "※電話番号を入力してください");
			return "accountUpdate";
		}
		try {
			long phoneNumber = Long.parseLong(tel);
		} catch (NumberFormatException e) {
			model.addAttribute("msg", "入力は電話番号にしてください");
			return "accountUpdate";
		}

		if(pass==null||pass.equals("")) {
			model.addAttribute("msg", "※今までのパスワードを入力してください");
			return "accountUpdate";
		}
		if (pass.equals(upd.findByUserId(user.getUserId()).get(0).getPassword())) {
			if (!newPass.equals("")) {
				form.setPass(newPass);
			}

			model.addAttribute("tell", tel);
			model.addAttribute("name", name);
			model.addAttribute("address", address);
			return "accountUpdateConfirm";
		}
		model.addAttribute("msg", "※パスワードが一致しません");
		return "accountUpdate";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String account(@ModelAttribute("yamazon") UserInsertForm form, HttpSession u_info, Model model) {
		return "account";

	}

	@RequestMapping(value = "/accountUpdateConfirm", method = RequestMethod.POST)
	public String accountUpdateConfirm(@ModelAttribute("yamazon") UserInsertForm form, HttpSession u_info,
			Model model) {

		User user = (User) session.getAttribute("user");

		String name = form.getName();
		String tel = form.getTel();
		String pass = form.getPass();
		String address = form.getAddress();
		int id = user.getUserId();

		//User users = new User(T,Un,A,P);

		upd.userUpdateId(tel, name, address, pass, id);
		session.setAttribute("user", upd.findByUserId(id).get(0));
		return "accountUpdateResult";
	}
}
