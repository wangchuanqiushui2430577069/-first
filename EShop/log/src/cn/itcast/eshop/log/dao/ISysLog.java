package cn.itcast.eshop.log.dao;

public interface ISysLog {

    /** 日志级别，普通消息 */
    public static final String Info = "INFO";
    /** 日志级别，警告消息 */
    public static final String Warn = "WARN";
    /** 日志级别，错误消息 */
    public static final String Error = "ERROR";


    void info (String msg);

    void warn (String msg);

    void error (String msg);

}
