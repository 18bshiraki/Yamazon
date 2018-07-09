package yamazon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.GoodsDao;
import yamazon.entity.Goods;

@Repository
public class GoodsDaoImpl implements GoodsDao {
	@Autowired
	JdbcTemplate jt;

	@Autowired
	private NamedParameterJdbcTemplate namedjt;

	public List<Goods> goodsSearch(String word) {
		String sql = "SELECT * FROM goods_info WHERE goods_name like ? or goods_name like ? or goods_name like ?";

		return jt.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), word + "%", "%" + word, "%" + word + "%");
	}

	//値がないとき全件検索
	public List<Goods> findAll() {
		List<Goods> list = jt.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info ORDER BY goods_number ASC ",
				new BeanPropertyRowMapper<Goods>(Goods.class));
		return list;
	}

	//検索用
	public List<Goods> findWord(String keyWord) {
		List<Goods> list = jt.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info WHERE goods_explain LIKE ? OR goods_explain LIKE ? OR goods_explain LIKE ? ORDER BY goods_number ASC ",
				new BeanPropertyRowMapper<Goods>(Goods.class),
				keyWord + "%", "%" + keyWord, "%" + keyWord + "%");
		return list;
	}

	public List<Goods> cart(int num) {
		String sql = "SELECT * FROM goods_info WHERE goods_number=?";

		return jt.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), num);
	}

	public List<Goods> detail(String name) {
		String sql = "SELECT * FROM goods_info WHERE goods_name=?";

		return jt.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class), name);
	}

	public List<Goods> goodsMenu() {
		return jt.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info ORDER BY random() LIMIT 4",
				new BeanPropertyRowMapper<Goods>(Goods.class));
	}

	//削除
	@Override
	public int delete(Goods goods) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(goods);
		return namedjt.update("DELETE FROM goods_info WHERE goods_number = :goodsNumber",
				paramSource);
	}

	//投稿
	@Override
	public int insert(Goods goods) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(goods);
		return namedjt.update(
				"INSERT INTO goods_info (goods_name, goods_explain, goods_image, price, tax_price, category, stock) VALUES (:goodsName, :goodsExplain, :goodsImage, :price, :taxPrice, :category, :stock)",
				paramSource);

	}

	//idを探す
	@Override
	public List<Goods> findIdGetPass(int goodsNumber) {
		List<Goods> list = jt.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info WHERE goods_number = ?",
				new BeanPropertyRowMapper<Goods>(Goods.class),
				goodsNumber);
		return list;
	}

	//更新
	@Override
	public int update(Goods goods) {
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(goods);
		return namedjt.update(
				"UPDATE goods_info SET goods_name = :goodsName, goods_explain = :goodsExplain, goods_image = :goodsImage, price = :price, tax_price = :taxPrice, category = :category, stock = :stock WHERE goods_number = :goodsNumber",
				paramSource);
	}
}
