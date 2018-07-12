package yamazon.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
public class GoodsInsertController {

	@Autowired
	GoodsDaoImpl goodsDao;

	@Autowired
	ServletContext context;

	@PostMapping(value = "/goodsInsertConfirm")
	public String goodsInsert(HttpSession session, @ModelAttribute("yamazon") GoodsForm form,
			@RequestParam("file") MultipartFile file, Model model)
			throws IllegalStateException, IOException {

		String name = form.getName();
		String explain = form.getExplain();
		String category = form.getCategory();
		String stock = form.getStock();
		String price = form.getPrice();
		String filename;

		if ((name == null || file == null || explain == null || category == null || stock == null || price == null)
				|| (("".equals(name) || file.isEmpty() || ("".equals(explain)) || ("".equals(category))
						|| ("".equals(stock)) || ("".equals(price))))) {
			model.addAttribute("msg", "すべての項目に入力してください");
			return "goodsInsert";
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

				//次画面へ渡す値のセット
				Goods goods = new Goods(name, explain, category, Integer.parseInt(stock), unitPrice, postTaxPrice);
				model.addAttribute("goods", goods);
				session.setAttribute("filePath", filePath);//画像持っていくpath
				return "goodsInsertConfirm";

			} else {
				Goods goods = new Goods(name, explain, category);
				model.addAttribute("goods", goods);
				model.addAttribute("msg", "値段と在庫は1以上で数字のみを入力してください");
				model.addAttribute("select", "再選択してください");
				return "goodsInsert";
			}
		}
	}

	@PostMapping(value = "/goodsInsertResult")
	public String goodsResult(HttpSession session, @ModelAttribute("yamazon") GoodsForm form, Model model) {

		String filePath = (String) session.getAttribute("filePath");

		//フォームから各Stringデータ
		String name = form.getName();
		String explain = form.getExplain();
		String category = form.getCategory();
		String stock = form.getStock();
		String price = form.getPrice();
		String taxPrice = form.getTaxPrice();

		Goods goods = new Goods(name, filePath, explain, category, Integer.parseInt(stock), Integer.parseInt(price),
				Integer.parseInt(taxPrice));
		goodsDao.insert(goods);

		session.removeAttribute("filePath");
		return "goodsInsertResult";
	}

	@GetMapping(value = "/goodsBack") //戻るボタン押したらファイル破棄
	public String goodsBack(HttpSession session, @ModelAttribute("yamazon") GoodsForm form, Model model) {

		String filePath = (String) session.getAttribute("filePath");

		//ファイルの削除
		File file = new File(context.getRealPath("/") + filePath);
		file.delete();

		model.addAttribute("msg", "再入力してください");

		session.removeAttribute("filePath");
		return "goodsInsert";
	}
}
