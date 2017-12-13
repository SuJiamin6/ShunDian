package com.lanou.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by lanou on 2017/12/7.
 */
public class OrdersInfo {

    private Integer orderId;//订单主键
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String order_time;//下单时间
    private Double totalMoney;//订单的总价
    private String AddressName;//收货人


    public String getAddressName() {
        return AddressName;
    }

    public void setAddressName(String addressName) {
        AddressName = addressName;
    }



    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public OrdersInfo() {
        super();
    }

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "orderId=" + orderId +
                ", order_time='" + order_time + '\'' +
                ", totalMoney=" + totalMoney +
                ", AddressName='" + AddressName + '\'' +
                '}';
    }
}
