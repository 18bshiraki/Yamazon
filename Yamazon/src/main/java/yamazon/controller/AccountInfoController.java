package yamazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.form.UserInsertForm;


@Controller
public class AccountInfoController {
//	@Autowired
//	HttpSession session;

	@RequestMapping(value = "/accountDelete", method = RequestMethod.GET)
	public String accountDelete(@ModelAttribute("yamazon")UserInsertForm form, Model model) {
		return "accountDelete";
	}

	@RequestMapping(value = "/accountUpdate", method = RequestMethod.GET)
	public String accountUpdate(@ModelAttribute("yamazon")UserInsertForm form, Model model) {
		return "accountUpdate";
	}
}
