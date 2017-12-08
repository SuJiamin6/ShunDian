package com.lanou.entity;

/**
 * Created by lanou on 2017/12/7.
 */
public class Orders {

    private Integer order_id;
    private String order_address;
    private String order_goodsName;
    private Double order_price;
    private Integer order_count;
    private Integer uesr_id;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_goodsName() {
        return order_goodsName;
    }

    public void setOrder_goodsName(String order_goodsName) {
        this.order_goodsName = order_goodsName;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public Integer getOrder_count() {
        return order_count;
    }

    public void setOrder_count(Integer order_count) {
        this.order_count = order_count;
    }

    public Integer getUesr_id() {
        return uesr_id;
    }

    public void setUesr_id(Integer uesr_id) {
        this.uesr_id = uesr_id;
    }

    public Orders() {
        super();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", order_address='" + order_address + '\'' +
                ", order_goodsName='" + order_goodsName + '\'' +
                ", order_price=" + order_price +
                ", order_count=" + order_count +
                ", uesr_id=" + uesr_id +
                '}';
    }
}
