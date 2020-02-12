package cn.itcast.eshop.goods.entity;

import cn.itcast.eshop.common.entity.Entity;

public class Goods extends Entity {

    /** 商品名称 */
    protected String name;
    /** 商品价格 */
    protected double price;
    /** 商品库存 */
    protected int number;
    /** 商品品牌 */
    protected String brand;

    /** 访问器  */
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getNumber() {
        return number;
    }
    public String getBrand() {
        return brand;
    }

    /** 修改器  */
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
