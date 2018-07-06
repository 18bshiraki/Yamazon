package yamazon.dao;

public interface PurchaseDao {
	public int history(Integer id, String name, Integer price, String time);

	public int stock(int stock, String name);
}
