package yamazon.entity;

public class Purchase {
	private int userId;
	private String goodsName;
	private int taxPrice;
	private String purchaseHistory;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(int taxPrice) {
		this.taxPrice = taxPrice;
	}

	public String getBuyHistory() {
		return purchaseHistory;
	}

	public void setBuyHistory(String purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}
}
