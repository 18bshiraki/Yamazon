package yamazon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.GoodsDao;
import yamazon.dao.ManagerDao;
import yamazon.dao.UserDao;
import yamazon.entity.Goods;
import yamazon.entity.Manager;
import yamazon.entity.User;
import yamazon.form.LoginForm;

@Controller
public class LoginController {
	@Autowired
	UserDao userdao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	GoodsDao goodsDao;
	@Autowired
	HttpSession session;

	@PostMapping("/menu")
	public String menu(@ModelAttribute("yamazon") LoginForm form, Model model) {
		String text = form.getPhoneNumber();
		if (text.length() < 10) {
			try {
				int id = Integer.parseInt(text);
				if (id == 1) {
					List<Manager> manager = managerDao.findByPhoneNumberAndPassword(id, form.getPassword());
					if (!manager.isEmpty()) {
						for (Manager managers : manager) {
							session.setAttribute("manager", managers);
						}
						model.addAttribute("manager", 1);
						return "managerMenu";
					}
					model.addAttribute("msg", "電話番号またはパスワードが間違っています。");
					return "login";
				} else if (id > 1) {
					List<Manager> manager = managerDao.findByPhoneNumberAndPassword(id, form.getPassword());
					if (!manager.isEmpty()) {
						for (Manager managers : manager) {
							session.setAttribute("manager", managers);
						}
						model.addAttribute("manager", 2);
						return "managerMenu";
					}
					model.addAttribute("msg", "電話番号またはパスワードが間違っています。");
					return "login";
				}
			} catch (NumberFormatException e) {
				model.addAttribute("msg", "電話番号またはパスワードが間違っています。");
				return "login";
			}
		}
		List<User> user = userdao.findByPhoneNumberAndPassword(form.getPhoneNumber(), form.getPassword());
		if (!user.isEmpty()) {
			for (User users : user) {
				session.setAttribute("user", users);
			}
			List<Goods> goods = goodsDao.goodsMenu();
			model.addAttribute("list", goods);
			return "menu";
		}
		model.addAttribute("msg", "電話番号またはパスワードが間違っています。");
		return "login";

	}
}
