package yamazon.controller;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import yamazon.dao.impl.GoodsDaoImpl;
import yamazon.entity.Goods;
import yamazon.form.GoodsForm;
import yamazon.model.Image;

@Controller
public class GoodsController {

	@Autowired
	GoodsDaoImpl goodsDao;

	@Autowired
	ServletContext context;

	@PostMapping(value = "/goodsSearchResult")
	public String select(@ModelAttribute("yamazon") GoodsForm form, Model model) {

		//キーワードを取得
		String keyWord = form.getKeyWord();

		if (keyWord == null || "".equals(keyWord)) {
			List<Goods> list = goodsDao.findAll();

			String cGoodsPrice = null;
			String cGoodsPriceTax = null;
			//値段に円とカンマ表示
			for (int i = 0; i < list.size(); i++) {
				NumberFormat nfCur = NumberFormat.getCurrencyInstance();
				cGoodsPrice = nfCur.format(list.get(i).getPrice());
				cGoodsPriceTax = nfCur.format(list.get(i).getTaxPrice());
				list.get(i).setCPrice(cGoodsPrice);
				list.get(i).setCTaxPrice(cGoodsPriceTax);
			}

			//スコープにセット
			model.addAttribute("goods", list);
			model.addAttribute("keyWord", keyWord);

			return "goodsSearchResult";
		} else {
			List<Goods> list = goodsDao.findWord(keyWord);

			//値段に円とカンマ表示
			Goods goods = list.get(0);
			int goodsPrice = goods.getPrice();
			int goodsTaxPrice = goods.getTaxPrice();
			NumberFormat nfCur = NumberFormat.getCurrencyInstance();

			String cGoodsPrice = nfCur.format(goodsPrice);
			String cGoodsPriceTax = nfCur.format(goodsTaxPrice);

			if (list.size() == 0) {
				model.addAttribute("msg", "該当する商品がありませんでした");
				return "goodsSearch";
			} else {
				//スコープにセット
				model.addAttribute("goods", list);
				model.addAttribute("goodsP", cGoodsPrice);
				model.addAttribute("goodsPT", cGoodsPriceTax);
				model.addAttribute("keyWord", keyWord);

				return "goodsSearchResult";
			}
		}

	}

	@GetMapping(value = "/goodsDeleteResult")
	public String delete(@ModelAttribute("yamazon") GoodsForm form, Model model) {
		String number = form.getNumber();
		Goods goods = new Goods(Integer.parseInt(number));
		List<Goods> list = goodsDao.findIdGetPass(Integer.parseInt(number));
		//ファイルの削除
		File file = new File(context.getRealPath("/") + list.get(0).getGoodsImage());
		file.delete();
		//データの削除
		goodsDao.delete(goods);

		return "goodsDeleteResult";

	}

	@GetMapping(value = "/goodsUpdateConfirm")
	public String update(HttpSession session, @ModelAttribute("yamazon") GoodsForm form, Model model) {//未実装
		String number = form.getNumber();
		String keyWord = form.getKeyWord();
		List<Goods> list = goodsDao.findIdGetPass(Integer.parseInt(number));
		Goods goods = list.get(0);
		session.setAttribute("goodsFile", goods.getGoodsImage());
		model.addAttribute("oldGoods", list.get(0));
		model.addAttribute("goods", list.get(0));
		model.addAttribute("keyWord", keyWord);
		return "goodsUpdateConfirm";

	}

	@PostMapping(value = "/goodsUpdateResult")
	public String updateResult(HttpSession session, @ModelAttribute("yamazon") GoodsForm form,
			@RequestParam("file") MultipartFile file, Model model)
			throws IllegalStateException, IOException {
		String number = form.getNumber();

		String name = form.getName();
		String explain = form.getExplain();
		String category = form.getCategory();
		String stock = form.getStock();
		String price = form.getPrice();

		String filename;

		List<Goods> list = goodsDao.findIdGetPass(Integer.parseInt(number));

		if ((name == null || explain == null || category == null || stock == null || price == null)
				|| (("".equals(name) || ("".equals(explain)) || ("".equals(category))
						|| ("".equals(stock)) || ("".equals(price))))) {
			model.addAttribute("msg", "画像アップロード以外のすべての項目に入力してください");
			model.addAttribute("oldGoods", list.get(0));
			model.addAttribute("goods", list.get(0));
			return "goodsUpdateConfirm";
		} else {
			//値段と在庫数が数字で入力されているか確認
			boolean bool;
			try {
				Integer.parseInt(stock);
				Integer.parseInt(price);
				bool = true;
			} catch (NumberFormatException e) {
				bool = false;
			}

			if (bool == true && Integer.parseInt(stock) > 0 && Integer.parseInt(price) > 0) {
				//税金計算
				int unitPrice = Integer.parseInt(price);
				double tax = 1.08;
				int postTaxPrice = (int) (unitPrice * tax);

				Goods goodsOld = list.get(0);

				if (file.getOriginalFilename() == null || file.isEmpty() == true) {
					if (name.equals(goodsOld.getGoodsName()) && explain.equals(goodsOld.getGoodsExplain())
							&& category.equals(goodsOld.getCategory())
							&& stock.equals(String.valueOf(goodsOld.getStock()))
							&& price.equals(String.valueOf(goodsOld.getPrice()))) {
						model.addAttribute("msg", "一か所以上変更してください");
						model.addAttribute("oldGoods", list.get(0));
						model.addAttribute("goods", list.get(0));
						return "goodsUpdateConfirm";
					} else {
						Goods goods = new Goods(Integer.parseInt(number), name, goodsOld.getGoodsImage(), explain,
								category,
								Integer.parseInt(stock), unitPrice, postTaxPrice);
						goodsDao.update(goods);
						return "goodsUpdateResult";
					}
				} else {
					//画像移し替え
					Image image = new Image();
					int dot = file.getOriginalFilename().lastIndexOf(".");
					String extention = "";
					if (dot > 0) {
						extention = file.getOriginalFilename().substring(dot).toLowerCase();
					}
					filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());

					if (file.getSize() > 0) {
						image.setName(filename + extention);

						image.setSize(file.getSize());

						File imageFile = new File(context.getRealPath("/") + "/images", image.getName());
						if (!imageFile.exists()) {
							File imageDir = new File(context.getRealPath("/") + "/images");
							imageDir.mkdir();
						}
						file.transferTo(imageFile);
					}
					String filePath = ("images/" + image.getName());
					Goods goods = new Goods(Integer.parseInt(number), name, filePath, explain, category,
							Integer.parseInt(stock), unitPrice, postTaxPrice);
					goodsDao.update(goods);
					return "goodsUpdateResult";
				}
			} else {
				Goods goods = new Goods(name, explain, category, list.get(0).getStock(), list.get(0).getPrice());
				model.addAttribute("goods", goods);
				model.addAttribute("oldGoods", list.get(0));
				model.addAttribute("msg", "値段と在庫は1以上で数字のみを入力してください");
				return "goodsUpdateConfirm";
			}
		}
	}

}
