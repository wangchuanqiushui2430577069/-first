package cn.itcast.eshop.client;

import cn.itcast.eshop.cart.action.CartAction;
import cn.itcast.eshop.cart.entity.CartGoods;
import cn.itcast.eshop.common.entity.Msg;
import cn.itcast.eshop.common.util.JSONUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartClient extends Client {



    //方便订单模块清空购物车
    public static CartAction cartAction ;

    //购物车总金额
    private String cartAmount ;

    public CartClient() {
        cartAction = new CartAction();
    }

    /** 数字编号和商品ID映射表 Map (Key：数字编号，Value：商品 ) */
    Map<Integer, CartGoods> cartToGoods;

    public String Index() {
        //展示商品列表
        String result = ShowCart();
        while(true) {
            if(result.equals(LOGIN)) { //登录
                //直接返回上层 Client
                return LOGIN;

            } else if(result.equals(EXIT)) {
                return EXIT;

            } else if(result.equals(ORDER)) {
                return ORDER;
            } else if(result.equals(INDEX)) {
                return INDEX;
            } else {
                System.out.println("输入错误，请重新输入");
                result = UserOperate("请根据序号进行操作","I 去凑单", "L 登录", "O 去结算");
            }
        }
    }

    /**
     * 添加购物车
     *
     * 把当前正在操作的商品对象添加到购物车中
     *  1.把 currentGoods 对象发送请求到 Action
     *  2.接受 Action 的响应消息
     * @return
     */
    public String addCart() {

        //1.把 currentGoods 对象发送请求到 Action
        cartAction.setGoods(currentGoods);
        //2.接受 Action 的响应消息
        String msgJson = cartAction.addCart();
        Msg msg = JSONUtil.JSONToEntity(msgJson, Msg.class);
        if(msg.getType().equals(Msg.Success)) {
            System.out.println("添加购物车成功");
        } else {
            System.out.println(msg.getMsg());
        }
        return UserOperate("请选择操作","I 继续浏览", "C 去购物车", "L 登录");
    }

    /*
        GoodsClient :
           currentGoods 肯定不为空
           赋值操作仅仅是对 GoodsClient 对象的属性 currentGoods 赋值
           CartClient 里的属性 currentGoods 并没有被赋值
        CartClient :
            currentGoods 为空
            CartClient 在创建对象的时候，其 currentGoods 是 null

        解决方案：
            父类Client 中的 currentGoods 用 static 修饰 使其子类对象共享同一个 currentGoods

     */

    /**
     * 展示购物车功能
     * 1.从服务器获取购物车数据 List<CartGoods>
     * 2.展示商品列表
     * 3.展示购物车总金额
     * @return
     */
    public String ShowCart() {
        System.out.println("\n【我的购物车】");
        System.out.println("编号\t\t商品名称\t\t单价\t\t数量");
        System.out.println("-----------------------------------------");
        String str;

        if(cartAction.cart.toString().equals("{}")) {
            System.out.println("---------------【购物车为空】---------------");
            str = UserOperate("请选择操作","I 返回首页", "E 退出");
            while(!str.equalsIgnoreCase("i") && !str.equalsIgnoreCase("e")) {
                System.out.println("--------【输入有误】--------");
                str = UserOperate("请选择操作", "I 返回首页", "E 退出");
            }
            return str;
        } else {
            String result = cartAction.showCart();
            Msg msg = JSONUtil.JSONToEntity(result, Msg.class);
            List<?> cartGoodsList = (List<?>)msg.getObj();  //购物车商品列表
            int i = 1;      //序号
            double sum = 0; //总金额
            cartToGoods = new HashMap<>(); //将编号和数据 ID 关联起来

            for (Object obj: cartGoodsList) {
                String json = obj.toString();
                CartGoods cartGoods = JSONUtil.JSONToEntity(json, CartGoods.class);
                int num = cartGoods.getGoodsNum();      //商品数量
                String name = cartGoods.getName();      //商品名称
                double price = cartGoods.getPrice();    //商品单价
                System.out.println(i + ".\t\t" + name + "\t\t\t" + price + "\t\t" +num);
                sum += price * num;
                cartToGoods.put(i++, cartGoods);

            }
            this.setCartAmount(sum + ""); // BigDecimal 进行精确运算
            setTotalAmount(sum + "");     // 方便订单模块获取购物金额
            System.out.println("总金额：" + sum);
            str = UserOperate("请选择操作","I 去凑单", "L 去登录", "O 去结算");
            while(!str.equalsIgnoreCase("i") && !str.equalsIgnoreCase("l")
                    && !str.equalsIgnoreCase("o")) {
                System.out.println("--------【输入有误】--------");
                str = UserOperate("请选择操作", "I 去凑单", "L 去登录", "O 去结算");
            }
            return str;
        }
    }


    public String getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(String cartAmount) {
        this.cartAmount = cartAmount;
    }
}
