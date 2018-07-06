package yamazon.controller;

import java.util.ArrayList;
import java.util.List;

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
	//List<String> kk;

	@PostMapping("/search")
	public String menu(@ModelAttribute("yamazon") Search form, Model model) {
		List<String> kk= new ArrayList<String>();
		for (int i = 0; i < goods.goodsSearch(form.getWord()).size(); i++) {
			String id = String.valueOf(goods.goodsSearch(form.getWord()).get(i).getGoodsNumber());

			kk.add(id);
		}
		model.addAttribute("search", goods.goodsSearch(form.getWord()));
		//model.addAttribute("id", kk);
		//model.addAttribute("num",goods.goodsSearch(form.getWord()).)
		return "searchResult";
	}
}
