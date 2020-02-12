package cn.itcast.eshop.goods.service.Impl;

import cn.itcast.eshop.goods.dao.GoodsDAO;
import cn.itcast.eshop.goods.dao.Impl.GoodsDAOImpl;
import cn.itcast.eshop.goods.entity.Goods;
import cn.itcast.eshop.goods.service.GoodsService;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 商品服务层
 * 处理商品模块的相关业务逻辑
 */
public class GoodsServiceImpl implements GoodsService {

    private GoodsDAO goodsDAO;

    public GoodsServiceImpl() {
        goodsDAO = new GoodsDAOImpl();
    }

    /**
     * 获取商品列表
     *
     * 1.调用 GoodsDAO 对象的方法获取数据并返回
     *
     * @return  商品列表
     * @throws Exception
     */
    public List<Goods> getGoodsList() throws Exception {


        return goodsDAO.getEntityList();
    }

    //返回购物车中的商品信息
    public List<Goods> getGoodsList(String[] ids) throws Exception {
        List<Goods> AllgoodsList = goodsDAO.getEntityList();
        List<Goods> goodsList = new ArrayList<>();

        int i = 0;
        while (i < ids.length) {
            if(ids[i] != null) {
                for (Goods g: AllgoodsList) {
                    if((g.getId()+"").equals(ids[i])) {
                        goodsList.add(g);
                    }
                }
            }
            i++;
        }
        return goodsList;
    }


    /**
     * 获取商品详情
     *
     * 1.根据商品 ID 获取商品对象
     * 2.若该对象存在则返回，否则返回 null
     *
     * @return  Goods 对象 或 null
     * @throws Exception
     */
    public Goods getGoodsDetail() throws Exception {
        return null;
    }
}
