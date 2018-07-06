package yamazon.dao;

import java.util.List;

import yamazon.entity.Purchase;

public interface PurchaseDao {
	public int history(Integer id, String name, Integer price, String time);

	public int stock(int stock, String name);

	public List<Purchase> purchaseHistory(int userId);

	public List<Purchase> userid(int userid);

}
