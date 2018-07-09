package yamazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import yamazon.dao.ManagerDao;
import yamazon.entity.Manager;
import yamazon.form.ManagerForm;

@Controller
public class ManagerDeleteController {
	@Autowired
	ManagerDao managerDao;

	@GetMapping("/managerDeleteResult")
	String delete(@ModelAttribute("yamazon")ManagerForm form, Model model) {
		String id = form.getManagerId();
		int ids = Integer.parseInt(id);
		if(ids == 1) {
			List<Manager> manager = managerDao.findAll();
			model.addAttribute("list", manager);
			model.addAttribute("msg","管理者番号1を削除することは出来ません");
			return "managerSearch";
		}
		managerDao.delete(ids);
		return"managerDeleteResult";
	}

}
