package yamazon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.UserDao;
import yamazon.entity.User;
import yamazon.form.UserSearchForm;

@Controller
public class UserSearchController {

	//userSearch画面を表示
	@GetMapping("/userSearch")
	public String toUserSearch(
			@ModelAttribute("yamazon") UserSearchForm userSearchForm,
			Model model) {
		return "userSearch";
	}

	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;

	@GetMapping("/userSearchResult")
	public String userSearched(
			@ModelAttribute("yamazon") UserSearchForm userSearchForm,
			Model model) {

		//formの値の取得
		int id = (int) session.getAttribute("userId");

		//検索窓が空の場合
		if (id == 0) {
			//全検索
			List<User> userList = userDao.findAll();
			session.setAttribute("userList", userList);
			return "userSearchResult";
		}

		List<User> userList2 = userDao.findByUserId(id);

		session.setAttribute("userList", userList2);
		return "userSearchResult";
	}

	//userSearchからの検索
	@PostMapping("/userSearchResult")
	public String userSearch(
			@ModelAttribute("yamazon") UserSearchForm userSearchForm,
			Model model) {

		//formの値の取得
		String id = userSearchForm.getUserId();

		//検索窓が空の場合
		if (id == null || id.equals("")) {
			//全検索
			List<User> userList = userDao.findAll();
			session.setAttribute("userList", userList);
			int ids = 0;
			session.setAttribute("userId", ids);
			return "userSearchResult";
		}

		//IDを指定した場合
		//数字以外をtry catch
		try {
			//パラメータの値を型変換してデータベースから取得
			int userId = Integer.parseInt(id);
			List<User> userList2 = userDao.findByUserId(userId);

			//IDに該当する管理者がいない＝リストの中身が空の場合
			if (userList2.isEmpty()) {
				model.addAttribute("msg", "指定したIDのユーザーは登録されていません。");
				return "userSearch";

				//IDに該当する管理者がいる＝リストの中身がある場合
			} else {
				session.setAttribute("userList", userList2);
				model.addAttribute(id);
				session.setAttribute("userId", userId);
				return "userSearchResult";
			}

		} catch (NumberFormatException e) {
			model.addAttribute("msg", "正しく数値を入力してください。");
			return "userSearch";
		}

	}

}
