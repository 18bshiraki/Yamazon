package yamazon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yamazon.dao.GoodsDao;
import yamazon.form.Search;

@Controller
public class GoodsSearchController {
	@Autowired
	GoodsDao goods;

	//List<String> kk;

	@PostMapping("/search")
	public String menu(@ModelAttribute("yamazon") Search form, Model model) {
		List<String> kk = new ArrayList<String>();
		for (int i = 0; i < goods.goodsSearch(form.getWord()).size(); i++) {
			String id = String.valueOf(goods.goodsSearch(form.getWord()).get(i).getGoodsNumber());

			kk.add(id);
		}
		model.addAttribute("search", goods.goodsSearch(form.getWord()));
		//model.addAttribute("id", kk);
		//model.addAttribute("num",goods.goodsSearch(form.getWord()).)
		return "searchResult";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("goodsName") String name, HttpServletRequest request,
			@ModelAttribute("yamazon") Search form, Model model) {
		goods.detail(name);
		model.addAttribute("name", goods.detail(name).get(0).getGoodsName());
		model.addAttribute("price", goods.detail(name).get(0).getTaxPrice());
		model.addAttribute("category", goods.detail(name).get(0).getCategory());
		model.addAttribute("explain", goods.detail(name).get(0).getGoodsExplain());
		model.addAttribute("image", goods.detail(name).get(0).getGoodsImage());
		model.addAttribute("stock", goods.detail(name).get(0).getStock());
		model.addAttribute("id", goods.detail(name).get(0).getGoodsNumber());

		return "goodsDetail";
	}
}
