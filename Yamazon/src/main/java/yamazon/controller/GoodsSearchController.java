package yamazon.controller;

import java.text.NumberFormat;
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
import yamazon.entity.Goods;
import yamazon.form.Search;

@Controller
public class GoodsSearchController {
	@Autowired
	GoodsDao goods;

	//List<String> kk;

	@PostMapping("/search")
	public String menu(@ModelAttribute("yamazon") Search form, Model model) {
		List<Goods> good = goods.goodsSearch(form.getWord());
		if (good.isEmpty()) {
			//model.addAttribute("search", good);
			model.addAttribute("msg", "一致する商品がありませんでした");
			return "searchResult";
		}
		for (int i = 0; i < good.size(); i++) {
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();
			//good.get(i).setCPrice(nfCur.format(good.get(i).getPrice()));
			good.get(i).setCTaxPrice(nfCur.format(good.get(i).getTaxPrice()));
		}
		model.addAttribute("search", good);
		//model.addAttribute("searchs", cGoodsPriceTax);

		return "searchResult";

	}

	@GetMapping("/detail")
	public String detail(@RequestParam("goodsName") String name, HttpServletRequest request,
			@ModelAttribute("yamazon") Search form, Model model) {
		goods.detail(name);
		NumberFormat nfCur = NumberFormat.getCurrencyInstance();
		String price=nfCur.format(Integer.valueOf(goods.detail(name).get(0).getTaxPrice()));
		model.addAttribute("name", goods.detail(name).get(0).getGoodsName());
		model.addAttribute("price",price);
		model.addAttribute("category", goods.detail(name).get(0).getCategory());
		model.addAttribute("explain", goods.detail(name).get(0).getGoodsExplain());
		model.addAttribute("image", goods.detail(name).get(0).getGoodsImage());
		model.addAttribute("stock", goods.detail(name).get(0).getStock());
		model.addAttribute("id", goods.detail(name).get(0).getGoodsNumber());

		return "goodsDetail";
	}
}
