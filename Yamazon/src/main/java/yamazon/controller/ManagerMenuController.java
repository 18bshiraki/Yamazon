
package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import yamazon.entity.Manager;
import yamazon.form.GoodsForm;
import yamazon.form.LoginForm;


@Controller
public class ManagerMenuController {



	@Autowired
	HttpSession session;


	@GetMapping("/managerMenu")
	public String usus(@ModelAttribute("yamazon")  LoginForm  form, Model model) {
		Manager manager = (Manager)session.getAttribute("manager");
		int id = manager.getManagerId();
		if(id == 1) {
			model.addAttribute("manager",1);
			return "managerMenu";
		}
		model.addAttribute("manager",2);
		return "managerMenu";
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
	public String goodsInsert(@ModelAttribute("yamazon") GoodsForm form, Model model) {
		return "goodsInsert";
	}
	/*
	 * 〔管理者メニュー画面〕から〔商品の検索画面〕
	 */
	@GetMapping("/goodsSearch")
	public String goodsSearch(@ModelAttribute("yamazon") GoodsForm form, Model model) {
		return "goodsSearch";
	}

}

