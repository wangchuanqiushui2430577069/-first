package cn.itcast.eshop.log.dao.Impl;

import cn.itcast.eshop.log.dao.ISysLog;
import cn.itcast.eshop.log.entity.Log;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日志实现类
 * 在控制台打印日志信息
 *
 * 步骤：
 *      1.封装日志对象
 *      2.打印日志数据到控制台
 */
public class ConsoleLog implements ISysLog {

    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); //12:00 PM

    @Override
    public void info(String msg) {
        //1.封装日志对象
        String log = new Log(msg, Info, sdf.format(new Date())).toString();
        //2.打印日志数据到控制台
        System.out.println(log);
    }

    @Override
    public void warn(String msg) {
        //1.封装日志对象
        String log = new Log(msg, Warn, sdf.format(new Date())).toString();
        //2.打印日志数据到控制台
        System.out.println(log);
    }

    @Override
    public void error(String msg) {
        //1.封装日志对象
        String log = new Log(msg, Error, sdf.format(new Date())).toString();
        //2.打印日志数据到控制台
        System.out.println(log);
    }
}
