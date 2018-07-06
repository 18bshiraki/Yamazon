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
	private JdbcTemplate JdbcTemplate;

	public List<Purchase> userid(int userid) {
		return JdbcTemplate.query("SELECT user_id,goods_name,tax_price,purchase_history FROM purchase_info WHERE user_id= ?",
				new BeanPropertyRowMapper<Purchase>(Purchase.class),userid);
	}
}
