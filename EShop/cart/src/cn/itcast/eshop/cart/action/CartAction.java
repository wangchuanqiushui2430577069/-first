package cn.itcast.eshop.cart.action;

import cn.itcast.eshop.cart.entity.CartGoods;
import cn.itcast.eshop.common.action.BaseAction;
import cn.itcast.eshop.common.entity.Msg;
import cn.itcast.eshop.common.util.JSONUtil;
import cn.itcast.eshop.goods.entity.Goods;
import cn.itcast.eshop.goods.service.GoodsService;
import cn.itcast.eshop.goods.service.Impl.GoodsServiceImpl;

import java.util.*;

public class CartAction extends BaseAction {


    private Goods goods;

    //商品服务层对象
    private GoodsService goodsService;

    /**
     * 购物车对象
     *  key     商品 ID
     *  value   商品数量
     */
    public Map<String, Integer> cart = new HashMap<>();

    /** 构造方法 ，初始化 goodsService */
    public CartAction() {
        goodsService = new GoodsServiceImpl();
    }

    /**
     * 添加购物车
     *
     * 把数据存放到 cart 中
     * 1.如果购物车中已存在商品，把数量加一
     * 2.如果不存在，则给商品的 Key 值赋 1
     * @return  返回成功或失败的消息
     */
    public String addCart() {

        Msg msg = new Msg();
        try {

            Integer num = cart.get(goods.getId());
            if(num != null && num > 0) {      //判断商品是否存在
                //cart.replace(goods.getId(), num + 1);
                cart.put(goods.getId(), num + 1);
            } else {
                cart.put(goods.getId(), 1);
            }
            msg.setType(Msg.Success);

        } catch (Exception e) {
            msg.setType(Msg.Fail);
            msg.setMsg("服务器异常");
        }
        return JSONUtil.entityToJSON(msg);
    }

    /**
     * 展示购物车
     * 1.获取购物车所有商品 ID，并转成字符串，用逗号隔开
     * 2.通过 GoodService 对象获取对应的商品列表
     * 3.将 Goods 对象转成 CarGoods 对象
     * 4.封装到 Msg 对象并返回
     * @return
     */
    public String showCart() {
        int i = 0;
        Msg msg = new Msg();
        try {
            //购物车中所有商品的 ID
            String ids = Arrays.toString(cart.keySet().toArray()); // [id1, id2, id3]

            //  解析 HashMap ,得到 Key 字符串数组
            String[] IDS = new String[4];
            Set<String> keys = cart.keySet() ;
            Iterator<String> iter = keys.iterator() ;
            while (iter.hasNext()) {
                IDS[i] = iter.next() ;
                i++;
             }

            List<Goods> goodsList = goodsService.getGoodsList(IDS);
            List<CartGoods> cartList = new ArrayList<>();
            for (Goods g: goodsList) {
                CartGoods cg = new CartGoods();
                cg.setId(g.getId());
                cg.setGoodsNum(cart.get(g.getId()));
                cg.setName(g.getName());
                cg.setPrice(g.getPrice());
                cartList.add(cg);
            }
            msg.setType(Msg.Success);
            msg.setObj(cartList);

        } catch (Exception e) {
            msg.setType(Msg.Fail);
            msg.setMsg(e.getMessage());
        }

        return JSONUtil.entityToJSON(msg);
    }

    /**
     * 接受商品信息
     * @param currentGoods
     */
    public void setGoods(Goods currentGoods) { goods = currentGoods; }

    public Goods getGoods() { return goods; }
}
