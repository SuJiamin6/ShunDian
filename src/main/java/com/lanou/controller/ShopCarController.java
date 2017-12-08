package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lanou.Util.FastJson_All;
import com.lanou.entity.*;
import com.lanou.service.GoodsTypeService;
import com.lanou.service.ShouDiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by lanou on 2017/12/7.
 */
@Controller
@RequestMapping("/")
public class ShopCarController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private ShouDiZhiService shouDiZhiService;

    //=====================加入购物车功能模块================
    /*
    * 每次点击加入购物车就发送一个ajax请求，将当前商品的goods_id和数量传过来
    * 根据goods_id找到当前商品，再将当前商品的GoodsId,GoodsName,GoodsPrice,GoodsImageUrl找到
    *
    * */
    @RequestMapping("/addCar")
    public void addShop(Integer id, Integer count, HttpServletResponse response, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        //当前用户加入购物车，如果是在未登录的状态下，先需要让用户在右边栏登录
        User user = (User) session.getAttribute("users");
        if (user == null) {
            map.put("data", "ERROR");
        } else {
            //根据商品的id查找到当前商品
            Goods goods = goodsTypeService.findGoodsById(id).get(0);
            //将当前查找到的商品的信息整合
            //在根据商品的goods_id,查找当前ShopCar表中是否有当前goods_id
            int goods_id = goods.getgId();
            ShopCar shopCar1 = goodsTypeService.findShopCargoods_id(goods_id);
            if (shopCar1 != null) {
                //1、当前商品存在ShopCar表中
                shopCar1.setGoods_count(shopCar1.getGoods_count() + count);
                shopCar1.setGoods_sum(shopCar1.getGoods_count() * shopCar1.getGoods_price());
                goodsTypeService.updateShopCar1(shopCar1.getGoods_count(), shopCar1.getGoods_sum(), shopCar1.getGoods_id());
            } else {
                //2、当前商品不存在于ShopCar表中
                ShopCar shopCar = new ShopCar();
                shopCar.setGoods_id(goods.getgId());
                shopCar.setGoods_name(goods.getgName());
                shopCar.setGoods_price(goods.getgPrice());
                shopCar.setGoods_count(count);
                shopCar.setGoods_sum(goods.getgPrice() * count);
                goodsTypeService.updateShopCar
                        (shopCar.getGoods_id(), shopCar.getGoods_name(), shopCar.getGoods_price(),
                                shopCar.getGoods_count(), shopCar.getGoods_sum());
            }
            map.put("data", "SUCCESS");
        }

        FastJson_All.toJson(map, response);

    }
    //============================================================================================

    @RequestMapping("/subCar")
    public void subShop(Integer id, Integer count, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //根据商品的id查找到当前商品
        Goods goods = goodsTypeService.findGoodsById(id).get(0);

        ShopCar shopCar1 = goodsTypeService.findShopCargoods_id(goods.getgId());
        shopCar1.setGoods_count(shopCar1.getGoods_count() - count);
        shopCar1.setGoods_sum(shopCar1.getGoods_count() * shopCar1.getGoods_price());
        goodsTypeService.updateShopCar1(shopCar1.getGoods_count(), shopCar1.getGoods_sum(), shopCar1.getGoods_id());

        map.put("data", "SUCCESS");
        FastJson_All.toJson(map, response);

    }

    @RequestMapping("/delCar")
    public void delShop(Integer id, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        goodsTypeService.deleteShopCar(id);
        map.put("data", "SUCCESS");
        FastJson_All.toJson(map, response);

    }

    //====================侧边栏点击购物车模块=====================
    /*
    * 点击侧边栏购物车模块的时候，查找ShopCar表中的数据，把所有的数据给前端
    * */
    @RequestMapping("/lookShopCar")
    public void lookShopCar(HttpServletResponse response, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        User user = (User) session.getAttribute("users");
        if (user == null) {
            map.put("data", "ERROR");
        } else {
            //将ShopCar表中所有的数据查找出来
            List<ShopCar> shopCars = goodsTypeService.findShopCar();
            int count = 0;
            double price = 0;
            for (int i = 0; i < shopCars.size(); i++) {
                count += shopCars.get(i).getGoods_count();
                price += shopCars.get(i).getGoods_sum();
            }
            map.put("data", shopCars);
            map.put("count", count);
            map.put("price", price);
        }
        FastJson_All.toJson(map, response);

    }
    //============================================================

    //====================侧边栏点击结算功能模块==================
    /*
    *  传过来的是商品的Goods_id
    * {"aId":1-2-5}
    * */
    @RequestMapping("/account")
    public void account(String aId, HttpServletResponse response, HttpSession session, HttpServletRequest request){

        //先接收到session中用户的id
        User user = (User) session.getAttribute("users");
        int uId = user.getuId();
        List<ShouDiZhi> shouDiZhi = shouDiZhiService.findShouDiZhi(uId);

        String[] ss=aId.split("\\-");

        List<ShopCar> shopCars = new ArrayList<ShopCar>();
        for(int i=0;i<ss.length;i++){
            ShopCar shopCar = goodsTypeService.findShopCargoods_id(Integer.parseInt(ss[i]));
            shopCars.add(shopCar);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        //把他们返回给前端
        int count = 0;
        double price = 0;
        String Goods_name = "";
        String Goods_name1 = "";
        for(int i=0;i<shopCars.size();i++){
            count += shopCars.get(i).getGoods_count();
            price += shopCars.get(i).getGoods_sum();
            Goods_name1 += shopCars.get(i).getGoods_name();
            Goods_name1 += " ";
        }
//        String address = shouDiZhi.get(0).getsName()+" "+shouDiZhi.get(0).getsArea()+" "+shouDiZhi.get(0).getsAddress()+" "+
//                shouDiZhi.get(0).getsZip()+" "+shouDiZhi.get(0).getsPhone();
//        String address1 = shouDiZhi.get(0).getsName()+":"+shouDiZhi.get(0).getsArea()+":"+shouDiZhi.get(0).getsAddress()+":"+
//                shouDiZhi.get(0).getsZip()+":"+shouDiZhi.get(0).getsPhone();

        map.put("count",count);
        map.put("price",price);
        map.put("data",shopCars);
        map.put("address",shouDiZhi);
        request.getSession().setAttribute("count",count);
        request.getSession().setAttribute("price",price);
//        request.getSession().setAttribute("address",address);
//        request.getSession().setAttribute("address1",address1);
        request.getSession().setAttribute("goodsName",Goods_name1);
        FastJson_All.toJson(map,response);
    }


    //====================生成订单界面==================
    @RequestMapping("/order")
    public void orders(Integer sId,HttpServletResponse response, HttpSession session){

            //先接收到session中用户的id
            User user = (User) session.getAttribute("users");

            int uId = user.getuId();
            int count = (Integer) session.getAttribute("count");
            double price = (Double) session.getAttribute("price");

            ShouDiZhi shouDiZhi = shouDiZhiService.findShouDiZhiBysId(sId);
            String address = shouDiZhi.getsName()+" "+shouDiZhi.getsArea()+" "+shouDiZhi.getsAddress()+" "+
                                    shouDiZhi.getsZip()+" "+shouDiZhi.getsPhone();
//            String address = (String) session.getAttribute("address");
//            String address1 = (String) session.getAttribute("address1");
            String goodsName = (String) session.getAttribute("goodsName");

            goodsTypeService.addOrders(address, goodsName, price, count, uId);

            Orders orders = goodsTypeService.findOrders(uId);
            int order_id = orders.getOrder_id();

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("order_id", order_id);
            map.put("count", count);
            map.put("price", price);
            map.put("goodsName", goodsName);
            map.put("address", address);
            goodsTypeService.deleteShopCarAll();
            FastJson_All.toJson(map, response);

        }

}
