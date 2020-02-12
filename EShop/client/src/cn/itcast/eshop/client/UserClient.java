package cn.itcast.eshop.client;

import cn.itcast.eshop.common.entity.Msg;
import cn.itcast.eshop.common.util.JSONUtil;
import cn.itcast.eshop.user.action.UserAction;



/**
 * 用户操作界面
 * 所有和用户有关的内容，都放到这个类中
 */
public class UserClient extends Client{

    /**
     * 用户登录操作界面
     * 1.使用控制台提示用户输入用户名和密码
     * 2.向服务器发送请求，并返回消息字符串
     *      使用 setter 方法把数据传递给  Action
     *      调用 Action 的登录功能
     * 3.解析消息字符串，提示用户信息
     * 4.页面跳转，使用字符串常量作为跳转标记
     *      成功，返回上一界面
     *      失败，返回首页
     * @return
     */
    public String ShowLogin(){
        System.out.println("----------------【欢迎登录】--------------");
        //1.使用控制台提示用户输入用户名和密码
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        //  2.向服务器发送请求，并返回消息字符串
        UserAction useraction = new UserAction();
        //    2.1  使用 setter 方法把数据传递给  Action
        useraction.setUsername(username);
        useraction.setPassword(password);
        //    2.2  调用 Action 的登录功能
        String result = useraction.login();

        //  3.解析消息字符串，提示用户信息
        Msg msg = JSONUtil.JSONToEntity(result, Msg.class);

        if(msg.getType().equals(Msg.Success)) { //登录成功
            System.out.println(msg.getMsg());
            //4.页面跳转，成功，返回上一此操作的界面
            return HISTORY;
        } else {
            System.out.println(msg.getMsg());
            //4.页面跳转，失败，返回首页
            return LOGIN;
        }
    }


}
