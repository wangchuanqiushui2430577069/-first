package cn.itcast.eshop.client;

import cn.itcast.eshop.common.entity.Msg;
import cn.itcast.eshop.common.util.JSONUtil;
import cn.itcast.eshop.goods.action.GoodsAction;
import cn.itcast.eshop.goods.entity.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsClient extends Client{

    Map<String, Goods> codeToGoods = new HashMap<>();
    /**
     * 商品管理首页
     *
     * 商品页面跳转控制器
     *  本模块的操作由此方法控制
     *  其他模块的操作返回上层，由 Client 控制提供
     * @return  返回公共操作
     */
    public String Index() {
        ShowGoodsList();
        String result = UserOperate("请根据序号查看商品详情", "L登录：", "I首页", "V查看订单", "B查看购物车");
        while(true) {
            if(result.equals(LOGIN)) {
                return LOGIN;

            } else if(result.equals(EXIT)) {
                return EXIT;

            } else if(result.equals(INDEX)) {
                return INDEX;
            } else if(result.equals(VIEW)) {
                return VIEW;
            } else if(result.equals(BOUGHT)) {
                return BOUGHT;
            }
            Goods goods = codeToGoods.get(result); //返回结果： 数据或 null
            if(goods != null) {             //查看详情
                currentGoods = goods;       //利用全局变量展示商品详情
                ShowGoodsDetail();
                result = UserOperate("输入 A 加入购物车", "L登录：", "I首页");

            } else if(result.equals(ADD)) { //加入购物车
                return ADD;

            } else {
                System.out.println("输入错误，请重新输入!");
                result = UserOperate("请根据序号查看商品详情", "L登录：");
            }
        }
        //return result;
    }

    /**
     * 展示商品列表
     *  1.向后台发送请求，获取商品数据
     *  2.解析相应消息字符串
     *  3.展示商品列表
     */

    public void ShowGoodsList() {
        //1.向后台发送请求，获取商品数据
        GoodsAction goodAction = new GoodsAction();
        String msgJSON = goodAction.GetGoodsList(); //传来的JSON文件
        //2.解析相应消息字符串
        Msg msg = JSONUtil.JSONToEntity(msgJSON, Msg.class);
        Object obj = msg.getObj();  //数据存放在 obj 对象里, [{}, {}, {}]
        List<?> goodsListJson = (List<?>)obj; //强制转换为列表

        System.out.println("【商品列表】");
        System.out.println("编号\t\t商品名称\t\t单价\t\t库存"); //  \t制表位，tab
        System.out.println("-------------------------------------------");
        int index = 1;
        for(Object o : goodsListJson) {
            String goodsJSON = o.toString(); // 这里就是 goods 对象的JSON 字符串
            Goods goods = JSONUtil.JSONToEntity(goodsJSON, Goods.class);

            String name = goods.getName(); //商品名称
            String price = goods.getPrice() + ""; //单价
            String number = goods.getNumber() + ""; //库存
            //3.展示商品列表
            System.out.println(index + ".\t\t" + name + "\t\t\t" + price + "\t\t" + number);
            goods.setId(index + "");
            codeToGoods.put(index + "", goods); //将商品的编号与商品进行一一映射
            index++;

        }

    }

    /**
     * 查看商品详情
     * 1.通过 ID 获取数据，然后进行展示
     * 2.在展示商品的时候，把商品列表存储起来，然后，当选择商品编号，就把对应的商品展示出来
     *      Map<String , Goods>  [ key --> 编号 ， Value -->商品对象
     */
    public void ShowGoodsDetail() {

        System.out.println("【商品详情】");
        System.out.println("编号\t\t商品名称\t\t单价\t\t库存\t\t品牌");
        System.out.println("----------------------------------------------");

        String name = currentGoods.getName();           //商品名称
        String price = currentGoods.getPrice() + "";    //单价
        String number = currentGoods.getNumber() + "";  //库存
        String brand = currentGoods.getBrand();         //品牌
        //3.展示商品列表
        System.out.println(1 + ".\t\t" + name + "\t\t\t" + price + "\t\t" + number + "\t\t" + brand);
    }
}
