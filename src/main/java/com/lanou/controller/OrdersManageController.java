package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Orders;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by lanou on 2017/12/11.
 */
@Controller
@RequestMapping("/")
public class OrdersManageController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    /*
    * 订单管理模块
    *       订单列表（订单号，收货人,总金额）
    *       查询功能（订单号、收货人（用户的id））
    *       增删改查功能
    * */

    @RequestMapping("/finds")
    public void findGoods(HttpServletResponse response){

        Map<String,Object> maps = new HashMap<String,Object>();
        //订单列表的展示
        List<Orders> ordersList = goodsTypeService.findAllOrders();

        System.out.println(ordersList);
        maps.put("ordersList",ordersList);
        FastJson_All.toJson(maps,response);
    }

}
