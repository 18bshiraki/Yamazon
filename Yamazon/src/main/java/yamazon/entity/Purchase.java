package yamazon.entity;

public class Purchase {
	private int userId;
	private String goodsName;
	private int taxPrice;
	private String purchaseHistory;
	private String CPrice;
	private String CTaxPrice;

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

	public String getPurchaseHistory() {
		return purchaseHistory;
	}

	public void setPurchaseHistory(String purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}

	public String getCPrice() {
		return CPrice;
	}

	public void setCPrice(String cPrice) {
		this.CPrice = cPrice;
	}

	public String getCTaxPrice() {
		return CTaxPrice;
	}

	public void setCTaxPrice(String cTaxPrice) {
		this.CTaxPrice = cTaxPrice;
	}
}
