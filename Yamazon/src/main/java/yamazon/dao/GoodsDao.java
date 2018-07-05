package yamazon.dao;

import yamazon.entity.Goods;

public interface GoodsDao {

	int delete(Goods goods);

	int insert(Goods goods);

}
