package yamazon.controller;

import java.text.NumberFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yamazon.dao.PurchaseDao;
import yamazon.dao.UserDao;
import yamazon.entity.Purchase;
import yamazon.entity.User;
import yamazon.form.PuchaseForm;
import yamazon.form.UserSearchForm;

@Controller
public class PurchaseHistoryController {

	@Autowired
	PurchaseDao purchaseDao;

	@Autowired
	HttpSession session;

	@Autowired
	UserDao userDao;

	@Autowired
	PurchaseDao src;

	@RequestMapping("/purchaseHistory")
	public String purchaseHistory (
			@ModelAttribute("yamazon")
			UserSearchForm userSearchForm,
			Model model ) {

		//テーブル(form）からIDの値を取得して型変換
		String historyId = userSearchForm.getId();
		int userId = Integer.parseInt(historyId);

		List<User> userList = userDao.findByUserId(userId);
		for(User users:userList)

		session.setAttribute("userList", users);

		List<Purchase> purchaseList = purchaseDao.purchaseHistory(userId);
		for (int i = 0; i < purchaseList.size(); i++) {
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			//good.get(i).setCPrice(nfCur.format(good.get(i).getPrice()));
			purchaseList.get(i).setCTaxPrice(nfCur.format(purchaseList.get(i).getTaxPrice()));
		}

		model.addAttribute("purchase", purchaseList);

		return "userSearchPurchaseResult";

	}

	@RequestMapping(value = "/accountPurchase", method = RequestMethod.GET)
	public String accountPurchase(@ModelAttribute("yamazon") PuchaseForm form, Model model) {

		User userid = (User) session.getAttribute("user");

		int id = userid.getUserId();

		List<Purchase> good = src.userid(id);
		for (int i = 0; i < good.size(); i++) {
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			//good.get(i).setCPrice(nfCur.format(good.get(i).getPrice()));
			good.get(i).setCTaxPrice(nfCur.format(good.get(i).getTaxPrice()));
		}

		model.addAttribute("goodslist", good);
		return "accountPurchase";

	}
}
