package cn.itcast.eshop.common.entity;

import java.util.UUID;

/**
  实体类
  所有模块实体类的父类
  职责：封装数据
 */
public class Entity {
    public Entity() {

    }

    /* 数据唯一标识 */
    private String id;

    /*  创建时间   */
    private String createTime;

    /*  删除时间   */
    private String deleteTime;

    /* 删除状态，0 已删除， 1 正常 ， 默认值为 1 */
    private String idDel = "1";


    /**
     * 通用唯一识别码，是由一组 32 位数的 16 进制数字构成的
     * 总共有 2^12个数字，大概是 3.4 * 10^38个
     * 特点： 不重复
     *举例： 550e8400-e29b-41d4-a716-446655440000
     *
     * @return  返回一个 UUID 字符串，不含连接符 "-"
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }


    /* 访问器 */
    public String getId() { return id; }

    public String getCreateTime() {
        return createTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public String getIdDel() {
        return idDel;
    }

    /* 修改器 */
    public void setId(String id) {
        this.id = id;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public void setIdDel(String idDel) {
        this.idDel = idDel;
    }
}
