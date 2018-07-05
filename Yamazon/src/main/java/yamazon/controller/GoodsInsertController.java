package yamazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import yamazon.dao.impl.GoodsDaoImpl;
import yamazon.entity.Goods;
import yamazon.form.GoodsForm;

@Controller
public class GoodsInsertController {

	@Autowired
	GoodsDaoImpl goodsDao;

	@PostMapping(value = "/goodsInsertConfirm")
	public String goodsInsert(@ModelAttribute("yamazon") GoodsForm form, Model model) {

		String name = form.getName();
		String image = form.getImage();
		String explain = form.getExplain();
		String category = form.getCategory();
		String stock = form.getStock();
		String price = form.getPrice();

		if ((name == null || image == null || explain == null || category == null || stock == null || price == null)
				|| (("".equals(name) || ("".equals(image)) || ("".equals(explain)) || ("".equals(category)) || ("".equals(stock)) || ("".equals(price))))) {
			return "goodsInsert";
		} else {
			//税金計算
			int unitPrice = Integer.parseInt(price);
			double tax = 1.08;
			int postTaxPrice = (int)(unitPrice * tax);

			Goods goods = new Goods(name, image, explain, category, Integer.parseInt(stock), unitPrice, postTaxPrice);
			model.addAttribute("goods", goods);
		}

		return "goodsInsertConfirm";
	}

	@PostMapping(value = "/goodsInsertResult")
	public String goodsResult(@ModelAttribute("yamazon")GoodsForm form, Model model) {
		return "goodsInsertResult";
	}
}
