package yamazon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.GoodsDao;
import yamazon.entity.Goods;

@Repository
public class GoodsDaoImpl implements GoodsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//値がないとき全件検索
	public List<Goods> findAll() {
		List<Goods> list = jdbcTemplate.query("SELECT user_id, user_name, telephone FROM user_info",
				new BeanPropertyRowMapper<Goods>(Goods.class));
		return list;
	}

	//検索用
	public List<Goods> findWord(String keyWord) {
		List<Goods> list = jdbcTemplate.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info WHERE goods_explain LIKE ? OR goods_explain LIKE ? OR goods_explain LIKE ?",
				new BeanPropertyRowMapper<Goods>(Goods.class),
				keyWord + "%", "%" + keyWord, "%" + keyWord + "%");
		return list;
	}

}
