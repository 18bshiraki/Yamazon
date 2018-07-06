package yamazon.dao;

import java.util.List;

import yamazon.entity.Purchase;

public interface PurchaseDao {

	public List<Purchase> purchaseHistory(int userId);
}
