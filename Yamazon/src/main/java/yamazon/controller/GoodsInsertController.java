package yamazon.controller;



import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String goodsInsert(HttpSession session, @ModelAttribute("yamazon") GoodsForm form, Model model) {

		String name = form.getName();
		String explain = form.getExplain();
		String category = form.getCategory();
		String stock = form.getStock();
		String price = form.getPrice();

		MultipartFile file = form.getFile();

		if ((name == null || file == null || explain == null || category == null || stock == null || price == null)
				|| (("".equals(name) || ("".equals(file.getName())) || ("".equals(explain)) || ("".equals(category))
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

			if (bool == true) {

				//税金計算
				int unitPrice = Integer.parseInt(price);
				double tax = 1.08;
				int postTaxPrice = (int) (unitPrice * tax);

				Goods goods = new Goods(name, explain, category, Integer.parseInt(stock), unitPrice, postTaxPrice);
				model.addAttribute("goods", goods);
				model.addAttribute("file", file.getOriginalFilename());
				session.setAttribute("file", file);//画像持っていく用
				return "goodsInsertConfirm";

			} else {
				Goods goods = new Goods(name, explain, category);
				model.addAttribute("goods", goods);
				model.addAttribute("file", file.getOriginalFilename());
				model.addAttribute("msg", "値段と在庫は数字で入力してください");
				model.addAttribute("select", "再選択してください");
				return "goodsInsert";
			}
		}
	}

	@PostMapping(value = "/goodsInsertResult")
	public String goodsResult(HttpServletRequest request, HttpSession session, @ModelAttribute("yamazon") GoodsForm form, Model model)
			throws IllegalStateException, IOException {
		//sessionからファイルのデータ
		MultipartFile file = (MultipartFile) session.getAttribute("file");
		System.out.println(file.getOriginalFilename());

		//フォームから各Stringデータ
		String name = form.getName();
		String explain = form.getExplain();
		String category = form.getCategory();
		String stock = form.getStock();
		String price = form.getPrice();
		String taxPrice = form.getTaxPrice();

		Image image = new Image();

		if (file.getSize() > 0) {
			image.setName(file.getOriginalFilename());

			image.setSize(file.getSize());

			File imageFile = new File(context.getRealPath("/") + "/images", image.getName());
			if (!imageFile.exists()) {
				File imageDir = new File(context.getRealPath("/") + "/images");
				imageDir.mkdir();
			}
			file.transferTo(imageFile);
		}
		System.out.println(image.getName());

		String filePath = (context.getRealPath("/") + "images/" + image.getName());
		Goods goods = new Goods(name, filePath, explain, category, Integer.parseInt(stock), Integer.parseInt(price), Integer.parseInt(taxPrice));
		goodsDao.insert(goods);

		session.removeAttribute("file");
		return "goodsInsertResult";
	}
}
