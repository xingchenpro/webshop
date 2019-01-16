package com.nb.shopping.entity;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/8
 */
public class Goods {

    private int id;
    private int number;//商品标识
    private String name;
    private double price;
    private double discount;//商品折扣
    private String desc;
    private String photo;
    private int count;//商品数量
    private String date;//日期
    private int status;//状态
    private int sellCount;//销售量
    private int typeId;
    private String goodsTypesName;
    private int orderCount;//该商品订单数量
    private Seller seller;

    public Goods() {
    }

    public Goods(int id, int number, String name, double price, double discount, String desc, String photo, int count, String date, int status, int sellCount, int typeId) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.desc = desc;
        this.photo = photo;
        this.count = count;
        this.date = date;
        this.status = status;
        this.sellCount = sellCount;
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getGoodsTypesName() {
        return goodsTypesName;
    }

    public void setGoodsTypesName(String goodsTypesName) {
        this.goodsTypesName = goodsTypesName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", desc='" + desc + '\'' +
                ", photo='" + photo + '\'' +
                ", count=" + count +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", sellCount=" + sellCount +
                ", typeId=" + typeId +
                ", goodsTypesName='" + goodsTypesName + '\'' +
                '}';
    }
}
