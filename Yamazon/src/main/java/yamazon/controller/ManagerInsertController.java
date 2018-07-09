package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.ManagerDao;
import yamazon.form.ManagerInsertForm;

/*
 * 登録画面コントローラ
 */
@Controller
public class ManagerInsertController {

	/*
	 * messages_ja.propertiesのメッセージ取得用
	 */
	@Autowired
	MessageSource messageSource;

	/*
	 * ユーザ情報サービス
	 */
	@Autowired
	private ManagerDao userInfoService;

	//@Autowired
	//private ManagerDao userInfoService;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/managerInsertConfirm", method = RequestMethod.POST)
	public String managerInsertConfirm(@ModelAttribute("yamazon") ManagerInsertForm form, Model model) {
		String name = form.getManagerName();
		String pass = form.getManagerPassword();
		if (name == null || name == "" || pass == null || pass == "") {
			model.addAttribute("msg", "名前またはパスワードに空欄があります。");
			return "managerInsert";
		}
		session.setAttribute("managerPass", form.getManagerPassword());
		return "managerInsertConfirm";
	}
	/*	@GetMapping("/managerInsertConfirm")
	public String Insert(@ModelAttribute("yamazon") ManagerInsertForm form, Model model) {
		return "managerInsertConfirm";

	}*/

	@RequestMapping(value = "/managerInsertResult", method = RequestMethod.POST)
	public String insertExecute(@ModelAttribute("yamazon") ManagerInsertForm form,
			Model model) {

		// セッションに保存したユーザ情報を取得
		String pass = (String) session.getAttribute("managerPass");
		//String pass = "aa";

		if (!form.getConfirmPassword().equals(pass)) {
			//String errorMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
			model.addAttribute("errmsg", "パスワードが一致しません");

			form.setConfirmPassword("");

			return "managerInsertConfirm";
		}

		userInfoService.insert(form.getManagerName(), form.getConfirmPassword());

		return "managerInsertResult";

	}
}