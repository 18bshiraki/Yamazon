package yamazon.dao;

import java.util.List;

import yamazon.entity.Goods;

public interface GoodsDao {
	public List<Goods> goodsSearch(String word);

	public List<Goods> cart(int num);

	public List<Goods> findAll();

	public List<Goods> findWord(String keyWord);

	public List<Goods> detail(String name);

	public List<Goods> goodsMenu();

	int delete(Goods goods);

	int insert(Goods goods);

	List<Goods> findIdGetPass(int goodsNumber);

	int update(Goods goods);
}
