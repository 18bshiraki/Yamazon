package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.UserDao;
import yamazon.form.UserSearchForm;

@Controller
public class UserDeleteController {

	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	//該当するユーザを削除
	@PostMapping("/userDeleteResult")
	public String userDelete(
			@ModelAttribute("yamazon")
			UserSearchForm userSearchForm,
			Model model) {

		//テーブル(form）からIDの値を取得して型変換
		String deleteId = userSearchForm.getId();
		int userId = Integer.parseInt(deleteId);

		//削除するメソッドにIDを渡す
		userDao.userDelete(userId);

		return "userDeleteResult";

	}
}
