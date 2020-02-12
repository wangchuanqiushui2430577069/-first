package cn.itcast.eshop.goods.dao;

import cn.itcast.eshop.goods.entity.Goods;

import java.util.List;

public interface GoodsDAO {

    List<Goods> getEntityList() throws Exception;
}
