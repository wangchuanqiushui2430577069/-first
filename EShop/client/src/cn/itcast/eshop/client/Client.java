package cn.itcast.eshop.client;



import cn.itcast.eshop.goods.entity.Goods;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 客户端顶层父类
 * 处理公共的用户操作
 */
public class Client {

    /** 全局 用户操作 首页 */
    public static final String INDEX = "I";
    /** 全局 用户操作 登录 */
    public static final String LOGIN = "L";
    /** 全局 用户操作 上一次操作 */
    public static String HISTORY = "I";
    /** 全局 用户操作 退出 */
    public static final String EXIT = "E";

    /** 全局 用户操作 添加 */
    public static final String ADD = "A";

    /** 全局 去结算 */
    public static final String ORDER = "O";

    /** 全局 去付款 */
    public static final String PAY = "P";

    /** 全局 查看订单 */
    public static final String VIEW = "V";

    /** 全局 模块 购物车 */
    public static final String CART = "C";

    /** 全局 模块 查看购物车 */
    public static final String BOUGHT = "B";

    /**  当前正在操作的商品对象 */
    protected static Goods currentGoods;

    /**  购物车中的总金额    */
    protected static String TotalAmount;

    public  String getTotalAmount() {
        return TotalAmount;
    }

    public  void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    /** 全局输入 */
    protected Scanner sc = new Scanner(System.in);

    protected SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); //12:00 PM


    public static void main(String[] args){
        Client c = new Client();
        c.start();
    }

    /**
     *  Debug 调试
     *  1.在可能出现问题的代码行设置断点
     *  2.以 Debug 模式运行
     *  F8 --> 单步执行
     *  F7 --> 进入方法
     *  shift + F8  --> 执行完毕方法
     *  F9 --> 进入下一个断点
     */
    private void start() {

        GoodsClient goodsClient = new GoodsClient();
        UserClient userClient = new UserClient();
        CartClient cartClient = new CartClient();
        OrderClient orderClient = new OrderClient();

        String result = goodsClient.Index(); //返回商品模块用户录入的公共操作

        while(true) {
            if(result.equals(INDEX)) {      //返回首页
                HISTORY = INDEX;
                result = goodsClient.Index();

            } else if(result.equals(LOGIN)) {   //进入登录页
                result = userClient.ShowLogin();

            } else if(result.equals(EXIT)) {  //退出
                System.out.println("--------------【已退出系统】------------");
                System.exit(0);

            } else if(result.equals(ADD)) {  //添加到购物车
                result = cartClient.addCart();
                /**  输入有误的情况  */
                while(!"C".equalsIgnoreCase(result) && !"I".equalsIgnoreCase(result)
                        && !"L".equalsIgnoreCase(result) &&
                        !"E".equalsIgnoreCase(result)) {
                    System.out.println("输入有误，请重新输入");
                    result = UserOperate("请选择操作","I 继续浏览", "C 去购物车", "L 登录");
                }

            } else if(result.equals(CART)) {  //去购物车
                HISTORY = CART;
                result = cartClient.Index();

            } else if(result.equals(BOUGHT)) {  //展示购物车商品
                HISTORY = BOUGHT;
                result = cartClient.ShowCart();

            } else if(result.equals(ORDER)) {  //去结算
                HISTORY = ORDER;
                //TODO 付款页面
                result = orderClient.Index();

            } else if(result.equals(PAY)) {  //去付款
                HISTORY = PAY;
                result = orderClient.ToPay();

            } else if(result.equals(VIEW)) {  //查询订单状态
                HISTORY = VIEW;
                if(orderClient.ShowOrder().equals("I 回首页，")) {
                    result = orderClient.ChangeToPay();
                } else {
                    result = "I";
                }

            } else {
                System.out.println("出错了。");
                break;
            }
        }

    }

    /**
     * 需求：创建公共的用户操作方法
     * 主要功能
     *      1.提示用户信息和用户操作
     *          请根据编号进行操作（或输入 L 登录; E 退出）
     *      2.接受用户的录入
     *          sc.nextLine();
     * 方法的分析：
     *      方法名：    UserOperate
     *      返回值：    String
     *      参数列表
     *          String msg;     用户信息
     *          String... oprs;     用户操作
     *              可变参数，本质是一个数组
     */
     public String UserOperate(String msg, String... oprs) {
         //oprs == String[]
         String opr = Arrays.toString(oprs); // [opr1,opr2,opr3]

         opr = opr.substring(1,opr.length()-1); /** 边界问题 */
         msg = msg + "（或 " + opr +" E 退出）";
         System.out.println(msg); //请根据编号进行操作（或输入 L 登录; E 退出 V 查看订单详情）
         return    sc.nextLine().trim().toUpperCase(); //去掉空格，转成大写
     }
}
