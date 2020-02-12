package cn.itcast.eshop.goods.dao.Impl;

import cn.itcast.eshop.common.dao.Impl.BaseDAOImpl;
import cn.itcast.eshop.goods.dao.GoodsDAO;
import cn.itcast.eshop.goods.entity.Goods;

import java.util.List;

public class GoodsDAOImpl extends BaseDAOImpl implements GoodsDAO {

    /**
     * 返回 dataAccess 对象获取数据列表并返回
     *
     * @return
     * @throws Exception
     */
    public List<Goods> getEntityList() throws Exception {
        return dataAccess.getList(Goods.class);
    }
}
