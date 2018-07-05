package yamazon.controller;

import java.text.NumberFormat;
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
		//検索の残骸
//		String result[] = keyWord.replaceAll("　", " ").split("\\s+");
//		System.out.println(keyWord);
//		for (int i = 0; i < result.length; i++) {//[3]
//            System.out.println(result[i]);//[4]
//        }

		if(keyWord == null || "".equals(keyWord)) {
			List<Goods> list = goodsDao.findAll();

			//値段に円とカンマ表示
			Goods goods = list.get(0);
			int goodsPrice = goods.getPrice();
			int goodsTaxPrice = goods.getTaxPrice();
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();

			String cGoodsPrice = nfCur.format(goodsPrice);
			String cGoodsPriceTax = nfCur.format(goodsTaxPrice);

			//スコープにセット
			model.addAttribute("goods", list);
			model.addAttribute("goodsP", cGoodsPrice);
			model.addAttribute("goodsPT", cGoodsPriceTax);

			return "goodsSearchResult";
		} else {
			List<Goods> list = goodsDao.findWord(keyWord);

			if(list.size() == 0) {
				model.addAttribute("msg", "該当する商品がありませんでした");
				return "goodsSearch";
			} else {
				//値段に円とカンマ表示
				Goods goods = list.get(0);
				int goodsPrice = goods.getPrice();
				int goodsTaxPrice = goods.getTaxPrice();
				NumberFormat nfCur = NumberFormat.getCurrencyInstance();

				String cGoodsPrice = nfCur.format(goodsPrice);
				String cGoodsPriceTax = nfCur.format(goodsTaxPrice);

				//スコープにセット
				model.addAttribute("goods", list);
				model.addAttribute("goodsP", cGoodsPrice);
				model.addAttribute("goodsPT", cGoodsPriceTax);

				return "goodsSearchResult";
			}
		}

	}

}
