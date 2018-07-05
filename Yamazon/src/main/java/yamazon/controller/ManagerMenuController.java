package yamazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerMenuController {

	/*
	 * 〔管理者メニュー画面〕から〔ユーザーの検索画面〕
	 */
	@GetMapping("/")
	public String usus(/*@ModelAttribute("yamazon") userSearchtForm form,*/ Model model) {
		return "managerMenu";
	}
	@GetMapping("/userSearch")
	public String userSearch(/*@ModelAttribute("yamazon") userSearchtForm form,*/ Model model) {
		return "userSearch";
	}
	/*
	 * 〔管理者メニュー画面〕から〔管理者の登録画面〕
	 */
	@GetMapping("/managerInsert")
	public String managerInsert(/*@ModelAttribute("yamazon") managerInsertForm form,*/ Model model) {
		return "managerInsert";
	}
	/*
	 * 〔管理者メニュー画面〕から〔管理者情報画面〕
	 */
	@GetMapping("/managerSearch")
	public String managerSearch(/*@ModelAttribute("yamazon") managerSearchForm form,*/ Model model) {
		return "managerSearch";
	}
	/*
	 * 〔管理者メニュー画面〕から〔商品の登録画面〕
	 */
	@GetMapping("/goodsInsert")
	public String goodsInsert(/*@ModelAttribute("yamazon") goodsInsertForm form,*/ Model model) {
		return "goodsInsert";
	}
	/*
	 * 〔管理者メニュー画面〕から〔商品の検索画面〕
	 */
	@GetMapping("/goodsSearch")
	public String goodsSearch(/*@ModelAttribute("yamazon") goodsSearchForm form,*/ Model model) {
		return "goodsSearch";
	}
	/*
	 * 〔管理者メニュー2画面〕から〔管理者情報の更新画面〕
	 */
	@GetMapping("/managerUpdate")
	public String managerUpdate(/*@ModelAttribute("yamazon") managerUpdateForm form,*/ Model model) {
		return "managerUpdate";
	}

}
