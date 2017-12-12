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
import java.util.Map;
import java.util.HashMap;
/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class CollectionController {

   @Autowired
   private CollectionService collectionService;
    //收藏夹 登陆后直接访问
   @RequestMapping("/findCollGoods.do")
   public void findCollection(String a,HttpSession session,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
       User user=(User)session.getAttribute("users");
      Integer user_id= user.getuId();
      List<Goods> result= collectionService.findCollection(user_id);
      System.out.println(result);

        map.put("result",result);
      FastJson_All.toJson(map,response);
   }
   //添加收藏 需要传进来goods_id
   @RequestMapping("finduser_id.do")
   public void finduser_id( Integer goods_id, HttpServletResponse response,HttpSession session){
       User user=(User)session.getAttribute("users");
      Integer user_id= user.getuId();
      Integer result= collectionService.finduser_id(user_id,goods_id);
       System.out.println("aaa:"+result);
      Number num=0;
      if (result!=null){
        num=1;   //可以查找到，已经收藏过了

      }else {
          collectionService.addCollGoods(user_id,goods_id);
          //返回0 ，收藏成功
      }
       FastJson_All.toJson(num,response);
   }


    //删除收藏
    @RequestMapping("/deleteCollection.do")
    public void deleteCollection(HttpSession session,Integer[] goods_id,HttpServletResponse response){
        User user=(User)session.getAttribute("users");
       Integer user_id= user.getuId();
        boolean result = false;
        if(collectionService.deleteCollection(goods_id,user_id)){
                    result=true;
                }
            FastJson_All.toJson(result,response);



    }
}
