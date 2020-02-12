package cn.itcast.eshop.goods.action;

import cn.itcast.eshop.common.action.BaseAction;
import cn.itcast.eshop.common.entity.Msg;
import cn.itcast.eshop.common.util.JSONUtil;
import cn.itcast.eshop.goods.entity.Goods;
import cn.itcast.eshop.goods.service.GoodsService;
import cn.itcast.eshop.goods.service.Impl.GoodsServiceImpl;


import java.util.List;

public class GoodsAction extends BaseAction {


    //商品实体对象
    private Goods goods;

    private GoodsService goodsService;

    public GoodsAction() {
        goodsService = new GoodsServiceImpl();
    }

    /**
     * 获取商品列表
     *  1.获取所有商品的对象列表
     *  2.将商品对象列表转换成字符串并返回
     *  3.异常处理
     *  4.记录日志
     *  5.响应消息到客户端
     */
    public String GetGoodsList() {
        Msg msg = new Msg();
        //ISysLog log = new ConsoleLog(); //在父类中编写
        //3.异常处理
        try {
            //1.获取所有商品的对象列表
            List<Goods> goodsList = goodsService.getGoodsList();
            //2.将商品对象列表转换成字符串并返回
            msg.setObj(goodsList);
            msg.setType(Msg.Success);

            String result = JSONUtil.entityToJSON(msg);
            //4.记录日志
            log.info("获取商品列表");
            //5.响应消息到客户端
            return result;
        } catch (Exception e) {
            msg.setType(Msg.Fail);
            msg.setMsg("获取商品列表失败，服务器异常！");
            //4.记录日志
            log.error("获取商品列表失败！" + e.getMessage());
        }

        return JSONUtil.entityToJSON(msg); //以封装的JSON文件返回

    }
    /**
     * 获取商品详情
     * @return
     */
    public String GetGoodsDetail() {
        Msg msg = new Msg();

        return JSONUtil.entityToJSON(msg);
    }
}
