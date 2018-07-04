package yamazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.GoodsDao;
import yamazon.form.Search;

@Controller
public class GoodsSearchController {
	@Autowired
	GoodsDao goods;

	@PostMapping("/search")
	public String menu(@ModelAttribute("yamazon") Search form, Model model) {

		model.addAttribute("search", goods.goodsSearch(form.getWord()));
		return "searchResult";
	}
}
