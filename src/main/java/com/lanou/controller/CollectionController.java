package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.DiZhi;
import com.lanou.entity.Goods;
import com.lanou.entity.User;
import com.lanou.service.CollectionService;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class CollectionController {

   @Autowired
   private CollectionService collectionService;
    //收藏夹
   @RequestMapping("/findCollGoods.do")
   @ResponseBody
   public List<Goods> findCollection(Integer user_id){

      List<Goods> result= collectionService.findCollection(user_id);
      System.out.println(result);
      return result;
   }
   @RequestMapping("finduser_id.do")
   public void finduser_id(Integer user_id, Integer goods_id, HttpServletResponse response){
      Integer result= collectionService.finduser_id(user_id,goods_id);
       System.out.println("aaa:"+result);
      Number num=0;
      if (result!=null){
        num=1;   //可以查找到，已经收藏过了
      }
        //返回0 ，没有收藏
       FastJson_All.toJson(num,response);
   }

   //判断是否是登录状态
    @RequestMapping("pandaun.do")
    public  void panduan (HttpServletResponse response,HttpSession session){

      User user=  (User) session.getAttribute("users");
      String name="YES";
       if (user==null){
           name="NO";
       }
        FastJson_All.toJson(name,response);
    }
    //添加收藏
    @RequestMapping("addCollGoods.do")
    public  void  addCollGoods(Integer user_id,Integer goods_id,HttpServletResponse response){
        boolean result=false;
        if (collectionService.addCollGoods(user_id,goods_id)){
            result=true;
        }
        FastJson_All.toJson(result,response);
    }
}
