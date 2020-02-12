package cn.itcast.eshop.common.action;


import cn.itcast.eshop.log.dao.ISysLog;
import cn.itcast.eshop.log.dao.Impl.ConsoleLog;

import java.util.HashMap;
import java.util.Map;

/**
 *  Action：控制器类的基类
 *  1.封装请求数据
 *  2.校验权限
 *  3.调用服务层，处理业务逻辑
 *  4.日志的记录
 *  5.返回消息到客户端
 */
public class BaseAction {

    /**     上下文对象的 key 登录用户 */
    public static final String Login_User = "LOGIN_USER";

    /**     上下文对象：专门用来存储所有 Action 类的公共的信息   */
    protected static final Map<String, Object> context = new HashMap<>();

    /**     日志实体    */
    protected ISysLog log = new ConsoleLog();


}
