package cn.itcast.eshop.common.entity;

/**
 * 消息封装类
 */
public class Msg {

    /* 消息类型 ，成功 */
    public static final String Success = "Success";
    /* 消息类型 ，失败 */
    public static final String Fail = "Fail";

    //消息类型：成功Success, 失败Fail
    private String type;
    //消息内容
    private String msg;

    //用于携带数据到客户端
    private Object obj;

    //访问器
    public String getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() { return obj; }

    //修改器
    public void setType(String type) {
        this.type = type;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object obj) { this.obj = obj; }
}
