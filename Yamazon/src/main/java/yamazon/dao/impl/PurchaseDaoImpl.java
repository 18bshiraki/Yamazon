package yamazon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.PurchaseDao;
import yamazon.entity.Purchase;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
	@Autowired
	JdbcTemplate jt;

	public int history(Integer id, String name, Integer price, String time) {
		String sql = "insert into purchase_info values(?,?,?,?)";

		return jt.update(sql, id, name, price, time);
	}

	public int stock(int stock, String name) {
		String sql = "UPDATE goods_info SET stock=? WHERE goods_name=?;";

		return jt.update(sql, stock, name);
	}

	@Override
	public List<Purchase> purchaseHistory(int userId) {
		String sql = "SELECT user_id, goods_name, tax_price, purchase_history"
				+ " FROM purchase_info WHERE user_id = ?";

		return jt.query(sql, new BeanPropertyRowMapper<Purchase>(Purchase.class), userId);
	}

	public List<Purchase> userid(int userid) {
		return jt.query("SELECT user_id,goods_name,tax_price,purchase_history FROM purchase_info WHERE user_id= ?",
				new BeanPropertyRowMapper<Purchase>(Purchase.class), userid);
	}

}
