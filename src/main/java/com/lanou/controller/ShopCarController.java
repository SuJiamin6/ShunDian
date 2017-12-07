package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Goods;
import com.lanou.entity.ShopCar;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
@Controller
@RequestMapping("/")
public class ShopCarController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    //=====================加入购物车功能模块================
    /*
    * 每次点击加入购物车就发送一个ajax请求，将当前商品的goods_id和数量传过来
    * 根据goods_id找到当前商品，再将当前商品的GoodsId,GoodsName,GoodsPrice,GoodsImageUrl找到
    *
    * */
    @RequestMapping("/addCar")
    public void addShop(Integer id,Integer count,HttpServletResponse response){

            //根据商品的id查找到当前商品
            Goods goods = goodsTypeService.findGoodsById(id).get(0);
            //将当前查找到的商品的信息整合
            //在根据商品的goods_id,查找当前ShopCar表中是否有当前goods_id
            int goods_id = goods.getgId();
            ShopCar shopCar1 = goodsTypeService.findShopCargoods_id(goods_id);
            if(shopCar1.getGoods_id()!=0){
                //1、当前商品存在ShopCar表中
                shopCar1.setGoods_count(shopCar1.getGoods_count()+count);
                shopCar1.setGoods_sum(shopCar1.getGoods_count()*shopCar1.getGoods_price());
            }else{
                //2、当前商品不存在于ShopCar表中
                ShopCar shopCar = new ShopCar();
                shopCar.setGoods_id(goods.getgId());
                shopCar.setGoods_name(goods.getgName());
                shopCar.setGoods_price(goods.getgPrice());
                shopCar.setGoods_count(count);
                shopCar.setGoods_sum(goods.getgPrice()*count);
                goodsTypeService.updateShopCar
                        (shopCar.getGoods_id(),shopCar.getGoods_name(),shopCar.getGoods_price(),
                                shopCar.getGoods_count(),shopCar.getGoods_sum());
            }



            System.out.println(shopCar);
            FastJson_All.toJson(goods,response);

    }

}
