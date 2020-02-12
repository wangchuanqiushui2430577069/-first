package cn.itcast.eshop.cart.entity;

import cn.itcast.eshop.goods.entity.Goods;

public class CartGoods extends Goods {

    //商品数量
    private int goodsNum;

    public int getGoodsNum() { return goodsNum; }

    public void setGoodsNum(int goodsNum) { this.goodsNum = goodsNum; }

    //将 Goods 对象转 CartGoods 对象
    public CartGoods(int goodsNum, String name, String brand, double price, int number) {
        this.goodsNum = goodsNum;
        this.name = name;
        this.brand = brand;
        this.number = number;
        this.price = price;
    }

    public CartGoods() {

    }
}
