package yamazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.impl.GoodsDaoImpl;
import yamazon.entity.Goods;
import yamazon.form.GoodsForm;

@Controller
public class GoodsController {

	@Autowired
	GoodsDaoImpl goodsDao;

	@PostMapping(value = "/goodsSearchResult")
	public String select(@ModelAttribute("yamazon") GoodsForm form, Model model) {

		//キーワードを取得
		String keyWord = form.getKeyWord();

		if(keyWord == null || "".equals(keyWord)) {
			List<Goods> list = goodsDao.findAll();
			model.addAttribute("goods", list);
			return "goodsSearchResult";
		} else {
			List<Goods> list = goodsDao.findWord(keyWord);
			if(list.size() == 0) {
				model.addAttribute("msg", "該当する商品がありませんでした");
				return "goodsSearch";
			} else {
				model.addAttribute("goods", list);
				return "goodsSearchResult";
			}
		}

	}

}
