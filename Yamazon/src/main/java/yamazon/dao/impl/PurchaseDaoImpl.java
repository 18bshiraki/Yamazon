package yamazon.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.PurchaseDao;

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
}