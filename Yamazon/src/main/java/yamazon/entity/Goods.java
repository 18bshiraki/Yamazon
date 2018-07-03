package yamazon.entity;

public class Goods {
	private int goodsNumber;
	private String goodsName;
	private String goodsExplain;
	private String goodsImage;
	private int price;
	private int taxPrice;
	private String category;
	private int stock;

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public int getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;

	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsExplain(String goodsExplain) {
		this.goodsExplain = goodsExplain;
	}

	public String getGoodsExplain() {
		return this.goodsExplain;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setTaxPrice(int taxPrice) {
		this.taxPrice = taxPrice;
	}

	public int getTaxPrice() {
		return this.taxPrice;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return this.category;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return this.stock;
	}

}
