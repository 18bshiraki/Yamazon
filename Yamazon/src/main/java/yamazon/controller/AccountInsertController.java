package yamazon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.UserDao;
import yamazon.entity.User;
import yamazon.form.UserInsertForm;

@Controller
public class AccountInsertController {

	@RequestMapping(value = "/userInsert", method = RequestMethod.GET)
	public String userInsert(@ModelAttribute("yamazon")UserInsertForm form, Model model) {
		return "userInsert";
	}

	@RequestMapping(value = "/userInsertConfirm", method = RequestMethod.POST)
	public String userInsertConfirm(@ModelAttribute("yamazon") UserInsertForm form,HttpSession u_info, Model model) {

		String Un = form.getName();
		String T = form.getTel();
		String P = form.getPass();
		String A = form.getAddress();
		if (Un.equals("") || Un.isEmpty()|| T.equals("") || T.isEmpty() || P.equals("") || P.isEmpty() || A.equals("") || A.isEmpty()) {
			model.addAttribute("text", "未入力の項目があります。");
			return "userInsert";
		}
		if(T.length() >11 ||T.length() <10) {
			model.addAttribute("text", "入力は電話番号にしてください");
			return"userInsert";
		}

			try {
				long phoneNumber=Long.parseLong(T);
			}catch(NumberFormatException e){
				model.addAttribute("text", "入力は電話番号にしてください");
				return"userInsert";
			}



		User user = new User(Un, T, P, A);
		u_info.setAttribute("u_info",user);

		return "userInsertConfirm";
	}

	@RequestMapping(value = "/userback", method = RequestMethod.GET)
	public String userback(@ModelAttribute("yamazon") UserInsertForm form, Model model) {
		return "userInsert";

	}
	@Autowired
	UserDao userdao;
	@RequestMapping(value = "/userInsertResult", method = RequestMethod.POST)
	public String userInsertResult(@ModelAttribute("yamazon") UserInsertForm form, Model model) {

		String Un = form.getName();
		String T = form.getTel();
		String P = form.getPass();
		String A = form.getAddress();

		userdao.insert(T,Un,A,P);

		return "userInsertResult";
	}
}
