package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.ManagerDao;
import yamazon.entity.Manager;
import yamazon.form.ManagerForm;

@Controller
public class ManagerUpdateController {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	HttpSession session;

	@GetMapping("/managerUpdate")
	public String managerUpdate(@ModelAttribute("yamazon") ManagerForm form, Model model) {
		return "managerUpdate";
	}

	@PostMapping("/managerUpdateConfirm")
	public String managerUpdateConfirm(@ModelAttribute("yamazon") ManagerForm form, Model model) {
		String name = form.getManagerName();
		String password = form.getManagerPassword();
		String rePassword = form.getRePassword();
		if (name == "" || name == null || password == "" || password == null || rePassword == ""
				|| rePassword == null) {
			model.addAttribute("msg", "入力されていない項目があります。");
			return "managerUpdate";
		}
		if(!password.equals(rePassword)) {

			model.addAttribute("msg", "更新するパスワードが一致しません。");
			return "managerUpdate";
	}
		return "managerUpdateConfirm";
	}
	@PostMapping("/managerUpdateResult")
	public String managerUpdateResult(@ModelAttribute("yamazon") ManagerForm form, Model model) {
		String name = form.getManagerName();
		String password = form.getManagerPassword();
		Manager manager = (Manager)session.getAttribute("manager");
		int id = manager.getManagerId();
		managerDao.update(name, password, id);
		return"managerUpdateResult";
	}

}