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

	public Goods() {
	}

	//商品登録確認画面に行くとき使用
	public Goods(String goodsName, String goodsExplain, String category, int stock, int price, int taxPrice) {
		this.goodsName = goodsName;
		this.goodsExplain = goodsExplain;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.taxPrice = taxPrice;
	}

	public Goods(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	//商品登録画面に戻るとき使用
	public Goods(String goodsName, String goodsExplain, String category) {
		this.goodsName = goodsName;
		this.goodsExplain = goodsExplain;
		this.category = category;
	}

	public Goods(String goodsName, String goodsImage, String goodsExplain, String category, int stock, int price,
			int taxPrice) {
		this.goodsName = goodsName;
		this.goodsImage = goodsImage;
		this.goodsExplain = goodsExplain;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.taxPrice = taxPrice;
	}

	public Goods(String goodsName, String goodsImage, String goodsExplain, String category, int stock) {
		this.goodsName = goodsName;
		this.goodsImage = goodsImage;
		this.goodsExplain = goodsExplain;
		this.category = category;
		this.stock = stock;
	}

	public Goods(int goodsNumber, String goodsName, String goodsImage, String goodsExplain, String category, int stock,
			int price,
			int taxPrice) {
		this.goodsNumber = goodsNumber;
		this.goodsName = goodsName;
		this.goodsImage = goodsImage;
		this.goodsExplain = goodsExplain;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.taxPrice = taxPrice;
	}

	public int getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;

	}

	public String getGoodsExplain() {
		return this.goodsExplain;
	}

	public void setGoodsExplain(String goodsExplain) {
		this.goodsExplain = goodsExplain;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTaxPrice() {
		return this.taxPrice;
	}

	public void setTaxPrice(int taxPrice) {
		this.taxPrice = taxPrice;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
