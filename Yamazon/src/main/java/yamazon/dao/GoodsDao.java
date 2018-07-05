package yamazon.dao;

import java.util.List;

import yamazon.entity.Goods;

public interface GoodsDao {
	public List<Goods> goodsSearch(String word);

	public List<Goods> goodsMenu();

	public List<Goods> cart(int num);

	public List<Goods> findAll();

	public List<Goods> findWord(String keyWord);
}
