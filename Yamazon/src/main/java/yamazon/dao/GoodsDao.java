package yamazon.dao;

import java.util.List;

import yamazon.entity.Goods;

public interface GoodsDao {
	public List<Goods> goodsSearch(String word);
}
