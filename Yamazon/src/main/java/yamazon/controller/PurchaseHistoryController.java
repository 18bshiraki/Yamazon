package yamazon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.PurchaseDao;
import yamazon.entity.Purchase;
import yamazon.entity.User;
import yamazon.form.PuchaseForm;

@Controller
public class PurchaseHistoryController {

	@Autowired
	PurchaseDao src;
    @Autowired
    HttpSession session;
	@RequestMapping(value = "/accountPurchase", method = RequestMethod.GET)
	public String accountPurchase(@ModelAttribute("yamazon")PuchaseForm form, Model model) {

		User userid = (User) session.getAttribute("user");

		int id = userid.getUserId();

		List<Purchase> good = src.userid(id);
		model.addAttribute("goodslist", good);
		return "accountPurchase";
	}
}
