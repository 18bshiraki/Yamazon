package yamazon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import yamazon.dao.UserDao;
import yamazon.entity.User;
import yamazon.form.UserSearchForm;

@Controller
public class UserUpdateController {

	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	//該当するユーザを検索
	@PostMapping("/userUpdateConfirm")
	public String userUpdateSearch (
			@ModelAttribute("yamazon")
			UserSearchForm userSearchForm,
			Model model) {

		//テーブル(form）からIDの値を取得して型変換
		String updateId = userSearchForm.getId();
		int userId = Integer.parseInt(updateId);

		session.setAttribute("userId", userId);

		//userIdから検索した情報を取得
		List<User> userList = userDao.findByUserId(userId);
		for(User users:userList)

		session.setAttribute("user", users);

		return "userUpdateConfirm";
			}

	//ユーザ情報の更新
	@RequestMapping("/userUpdateResult")
	public String userUpdate (
			@ModelAttribute("yamazon")
			UserSearchForm userSearchForm,
			Model model) {

		String newName = userSearchForm.getNewName();
		String newPhoneNumber = userSearchForm.getNewPhoneNumber();
		String newAddress = userSearchForm.getNewAddress();
		String newPassword = userSearchForm.getNewPassword();
		String rePassword = userSearchForm.getRePassword();

		System.out.println(newName);
		System.out.println(newAddress);
		System.out.println(newPassword);
		System.out.println(rePassword);

		//
		int userId = (int)session.getAttribute("userId");

		if (newName == null || newPhoneNumber == null || newAddress == null || newPassword == null || rePassword == null ||
				newName.equals("") || newPhoneNumber.equals("") || newAddress.equals("") || newPassword.equals("") || rePassword.equals("")) {

			model.addAttribute("msg", "すべての項目を入力してください。");
			return "userUpdateConfirm";

		}

		if (!newPassword.equals(rePassword)) {
			model.addAttribute("msg", "入力したパスワードと再入力したパスワードが一致しません。");
			return "userUpdateConfirm";
		} else {

		userDao.userUpdate(newPhoneNumber, newName, newAddress, newPassword, userId);

		return "userUpdateResult";
		}
	}
}

