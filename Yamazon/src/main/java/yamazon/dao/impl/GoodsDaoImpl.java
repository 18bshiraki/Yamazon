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
	JdbcTemplate jt;

	public List<Goods> goodsSearch(String word) {
		String sql = "SELECT * FROM goods_info WHERE goods_name like ? or goods_name like ? or goods_name like ?";

		return jt.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), word + "%", "%" + word, "%" + word + "%");
	}

	public List<Goods> cart(int num) {
		String sql = "SELECT * FROM goods_info WHERE goods_number=?";

		return jt.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), num);
	}
}
