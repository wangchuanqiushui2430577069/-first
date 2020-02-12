package cn.itcast.eshop.user.action;

import cn.itcast.eshop.common.action.BaseAction;
import cn.itcast.eshop.common.entity.Msg;
import cn.itcast.eshop.common.util.JSONUtil;
import cn.itcast.eshop.log.dao.ISysLog;
import cn.itcast.eshop.log.dao.Impl.ConsoleLog;
import cn.itcast.eshop.user.Service.UserService;
import cn.itcast.eshop.user.Service.impl.UserServiceImpl;
import cn.itcast.eshop.user.entity.User;

/**
 * 用户控制器类
 * 处理所有用户的后台操作，并返回JSON格式的字符串
 */
public class UserAction extends BaseAction {

    /**
     * 用户名
     * 密码
     */
    private String username;
    private String password;

    /**
     * 用户登录功能
     * 1.封装数据到 User 对象
     * 2.调用 UserService 处理逻辑
     *   User  login( User user ) throws Exception;
     * 3.异常处理
     * 4.根据服务层返回结果生成信息
     *      消息实体类 Msg
     * 5.记录日志（待开发）
     * 6.响应消息到客户端
     * @return
     */
    public String login(){

        Msg msg = new Msg();
        try {
            //1.封装数据到 User 对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            //2.调用 UserService 处理逻辑
            //      User  login( User user ) throws Exception;
            UserService userService = new UserServiceImpl();
            user = ((UserServiceImpl)userService).login(user);

            //3.异常处理

            //4.根据服务层返回结果生成信息
            //          消息实体类 Msg
            if(user != null) {
                context.put(Login_User, user);        //把当前用户登陆对象放到上下文对象
                msg.setType(Msg.Success);             //登录成功
                msg.setMsg("登陆成功！");
                //5.记录日志
                //ISysLog log = new ConsoleLog();     //在父类中编写
                log.info(username + "同学已登录"); // log 在父类中创建
            } else {
                msg.setType(Msg.Fail); //登录失败
                msg.setMsg("用户名或密码不正确！");
            }
             return JSONUtil.entityToJSON(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setType(Msg.Fail); //登录失败
            msg.setMsg("服务器异常！");
            return JSONUtil.entityToJSON(msg);
        }
    }

    /**
     * 获取当前登录用户对象
     * @return  返回用户对象，或 null
     */
    public User getLogin_User() {
        Object obj = context.get(Login_User);
        if(obj != null) {
            return (User) obj;
        }
        return null;
    }

    //访问器
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //修改器

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
