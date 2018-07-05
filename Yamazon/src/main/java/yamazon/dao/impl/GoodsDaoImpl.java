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
	private JdbcTemplate jt;

	@Autowired
	private NamedParameterJdbcTemplate namedjt;

	//値がないとき全件検索
	public List<Goods> findAll() {
		List<Goods> list = jt.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info",
				new BeanPropertyRowMapper<Goods>(Goods.class));
		return list;
	}

	//検索用
	public List<Goods> findWord(String keyWord) {
		List<Goods> list = jt.query(
				"SELECT goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock FROM goods_info WHERE goods_explain LIKE ? OR goods_explain LIKE ? OR goods_explain LIKE ?",
				new BeanPropertyRowMapper<Goods>(Goods.class),
				keyWord + "%", "%" + keyWord, "%" + keyWord + "%");
		return list;
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
				"INSERT INTO goods_info (goods_number, goods_name, goods_explain, goods_image, price, tax_price, category, stock) VALUES (:goodsNumber, :goodsName, :goodsExplain, :goodsImage, :price, :taxPrice, :category, :stock)",
				paramSource);
	}

}
