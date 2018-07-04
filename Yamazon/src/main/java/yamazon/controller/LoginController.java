package yamazon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.UserDao;
import yamazon.entity.User;
import yamazon.form.LoginForm;

@Controller
public class LoginController {
	@Autowired
	UserDao userdao;
	@Autowired
	HttpSession session;

	@PostMapping("/menu")
	public String menu(@ModelAttribute("yamazon")LoginForm form, Model model) {
		List<User> user = userdao.findByPhoneNumberAndPassword(form.getPhoneNumber(), form.getPassword());
		if(!user.isEmpty()) {
			for(User users:user) {
				session.setAttribute("user",users);
			}
			model.addAttribute("msg");
			return"menu";
		}
		model.addAttribute("msg", "電話番号またはパスワードが間違っています。");
		return "login";

	}
}
