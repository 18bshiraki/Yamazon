package yamazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.ManagerDao;
import yamazon.entity.Manager;
import yamazon.form.ManagerForm;

@Controller
public class ManagerSearchController {
	@Autowired
	ManagerDao managerDao;

	@RequestMapping(value = "/aaaaaaaaa", method = RequestMethod.GET)
	public String search(@ModelAttribute("yamazon") ManagerForm form,Model model) {
		List<Manager> manager = managerDao.findAll();
		model.addAttribute("list", manager);
		return "managerSearch";
	}
}
