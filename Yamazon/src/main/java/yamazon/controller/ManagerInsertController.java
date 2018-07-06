package yamazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.form.ManagerInsertForm;


/*
 * 登録画面コントローラ
 */
@Controller
public class ManagerInsertController {



	//@Autowired
	//private ManagerDao userInfoService;
	//@Autowired
	//private SessionInfo sessionInfo;
	@RequestMapping(value = "/managerInsertConfirm", method = RequestMethod.POST)
	public String managerInsertConfirm(@ModelAttribute("yamazon") ManagerInsertForm form, Model model) {

		return "managerInsertConfirm";
		}
	/*	@GetMapping("/managerInsertConfirm")
	public String Insert(@ModelAttribute("yamazon") ManagerInsertForm form, Model model) {
		return "managerInsertConfirm";

	}*/

//		@RequestMapping(value = "/managerInsertResult", method = RequestMethod.POST)
//		public String insertExecute(@ModelAttribute("yamazon") ManagerInsertForm form,
//				Model model) {
//
//			// セッションに保存したユーザ情報を取得
//			Manager manager = sessionInfo.getNewManager();
//
//			if (!manager.getManagerPassword().equals(form.getConfirmPassword())) {
//				String errorMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
//				model.addAttribute("errmsg", errorMsg);
//
//				form.setConfirmPassword("");
//
//				return "managerInsertConfirm";
//			}
//
//			userInfoService.insert(manager);
//			return "managerInsertResult";
//
//	}
}