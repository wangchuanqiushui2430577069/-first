package cn.itcast.eshop.client;

import cn.itcast.eshop.common.entity.Entity;
import cn.itcast.eshop.order.Order;
import cn.itcast.eshop.user.action.UserAction;


import java.util.Date;

//TODO 可设置订单数组
public class OrderClient extends Client{

    /*    当前操作订单对象      */
    private Order currentOrder;
    /*     当前购物车对象      */
    CartClient cartClient;

    public OrderClient() {
        cartClient = new CartClient();  //获取购物车总金额
    }

    /**
     * 订单管理页面
     * 生成订单：
     *      条件：
     *          1.购物车中有数据
     *          2.已登录
     *          3.录入收货人信息
     *      结果：
     *          封装 Order 对象
     *          订单状态为，待支付
     *          清空购物车
     * @return
     */
    public String Index() {
        //TODO 登录验证
        UserAction userAction = new UserAction();
        if(userAction.getLogin_User() != null) {
            generateOrder();
            //return UserOperate("请选择操作", "I 返回首页","P 去支付");
            String oprs = "I 返回首页 P 去支付";
            String str = UserOperate("请选择操作", oprs);
            while(!str.equalsIgnoreCase("i") && !str.equalsIgnoreCase("e")
                && !str.equalsIgnoreCase("p")) {
                System.out.println("--------【输入有误】--------");
                str = UserOperate("请选择操作", oprs);
            }
            return str;

        } else {
            return LOGIN;  //返回登录界面
        }
    }

    public String ToPay() {
        String oprs = ShowOrder();
        Pay();
        String str = UserOperate("请选择操作", oprs);
        while(!str.equalsIgnoreCase("i") && !str.equalsIgnoreCase("e")) {
            System.out.println("--------【输入有误】--------");
            str = UserOperate("请选择操作", oprs);
        }
        return str;
    }
    public void Pay() {
        //TODO 添加个相应框，点击确定支付订单
        currentOrder.setState(Order.Waiting_Completed);
        cartClient.setTotalAmount("0");
        cartClient.cartAction.cart.clear(); //清空购物车信息
        System.out.println("---------【支付成功】-----------");

    }

    /**
     *  生成订单
     *      1.填写订单信息
     *      2.封装成 Order 对象
     *      3.生成订单 --> 待支付状态
     */
    private void generateOrder() {

        /*      填写订单信息      */
        System.out.println("--------------------正在生成订单---------------------\n");

        System.out.println("请输入收货人");
        String consignee = sc.nextLine();
        System.out.println("请输入收货地址");
        String consigneeAddress = sc.nextLine();
        System.out.println("请输入联系人电话");
        String phone = sc.nextLine();

        /**    生成订单 --> 待支付状态 */
        currentOrder = new Order();
        currentOrder.setId(Entity.getUUID());               //订单 ID
        currentOrder.setCreateTime(sdf.format(new Date())); //订单生成日期
        currentOrder.setAmount(cartClient.getTotalAmount());  //订单总金额
        currentOrder.setConsigneeAddress(consigneeAddress); //收货地址
        currentOrder.setConsignee(consignee);               //收货人
        currentOrder.setPhone(phone);                       //收货人手机号
        String serialNumber = getSerialNumber();
        currentOrder.setSerialNumber(serialNumber);         //订单序列号
        currentOrder.setState(Order.Waiting_Pay);           //待支付

        System.out.println("---------------------订单已生成----------------------\n订单号，\t" +
                serialNumber + "\n总金额，\t" + cartClient.getTotalAmount() + "\n状态：\t待支付");

    }



    /**
     * 查看订单详情
     * TODO 后台查询数据
     *      查看当前订单数据
     *      查看历史订单数据
     * @return
     */
    public String ShowOrder() {

        String oprs = "I 回首页，";
        if(currentOrder != null) {
            System.out.println("\n【我的订单】");
            System.out.println("------------------------------------------------------");
            String createTime = currentOrder.getCreateTime();
            String amount = currentOrder.getAmount();
            String consigneeAddress = currentOrder.getConsigneeAddress();
            String cosignee = currentOrder.getConsignee();
            String phone = currentOrder.getPhone();
            String serialNumber = currentOrder.getSerialNumber();
            String state = currentOrder.getState();

            System.out.println("订单号，" + serialNumber + "\t\t下单时间，" + createTime +
                    "\t\t总金额，" + amount + "\t\t状态，" + getStateDescribtion(state));
            System.out.println("\n收货人：" + cosignee + "\n收货地址：" + consigneeAddress + "\n联系方式：" + phone);

            return oprs;
        } else {
            System.out.println("-----------------【无任何订单】----------------");
            System.out.println("--------------【页面将自动跳转至首页】--------------");
            return "I";
        }


    }

    //订单未支付，转入提示页面，提示用户进行下一步操作（支付订单 或 返回首页 ，或退出系统 ）
    public String ChangeToPay() {
        String oprs = "I 回首页，";
        if(currentOrder.getState().equals(Order.Waiting_Pay)) { //如果订单未支付，及提供支付功能
            oprs += "P 去支付";
        }
        String str = UserOperate("请选择操作", oprs);
        while(!str.equalsIgnoreCase("i") && !str.equalsIgnoreCase("e")
                && !str.equalsIgnoreCase("p")) {
            System.out.println("--------【输入有误】--------");
            str = UserOperate("请选择操作", oprs);
        }
        return str;
    }

    /**
     * 当前订单编号，跟据当前系统时间生成
     * @return
     */
    private String getSerialNumber() {
        String serialNumber = new Date().getTime() + "";
        int cartHash = this.hashCode();
        return serialNumber + cartHash;
    }


    public String getStateDescribtion(String state) {
        switch(state) {
            case Order.Waiting_Cancelled:
                return "已取消";
            case Order.Waiting_Completed:
                return "已完成";
            case Order.Waiting_Pay:
                return "待支付";
            case Order.Waiting_Receive:
                return "待收货";
            case Order.Waiting_Send:
                return "待发货";
            default :
                return "";
        }



    }












}
