package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.DiZhi;
import com.lanou.entity.ShouDiZhi;
import com.lanou.entity.User;
import com.lanou.service.DiZhiService;
import com.lanou.service.ShouDiZhiService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class ShouDiZhiController {

   @Autowired
   private ShouDiZhiService shouDiZhiService;
   @RequestMapping("findShouDiZhi.do")
   public void findShouDiZhi(Integer uId,HttpServletResponse response ,HttpSession session){
       User user=(User)session.getAttribute("users");
       uId= user.getuId();
        //接收到用户的uId返回对应的地址
       List<ShouDiZhi> result= shouDiZhiService.findShouDiZhi(uId);
       FastJson_All.toJson(result,response);
   }

   //添加收获地址
   //<!--需要传过来姓名等信息user_id自己从session中取-->
    @RequestMapping("addShouDiZhi.do")
   public  void addShouDiZhi(String sName, String sArea, String sAddress, String sZip, String sPhone, Integer user_id, HttpServletResponse response, HttpSession session){
    User user=(User)session.getAttribute("users");
       user_id= user.getuId();
       boolean result=false;

      if (shouDiZhiService.addShouDiZhi(sName,sArea,sAddress,sZip,sPhone,user_id)){
          result=true;  //添加成功返回true
      }
        System.out.println(result);
        //添加失败返回false
        FastJson_All.toJson(result,response);
   }

   //删除收获地址  需要传过来地址的id  user_id我自己从session中取
    @RequestMapping("deleteShouDiZhi.do")
    public void deleteShouDiZhi(Integer sId ,Integer user_id,HttpServletResponse response,HttpSession session){
        User user=(User)session.getAttribute("users");
        user_id= user.getuId();
        boolean result=false;
        if (shouDiZhiService.deleteShouDiZhi(sId,user_id)){
            result=true;   //删除成功返回true
        }
        //删除失败返回false
        FastJson_All.toJson(result,response);
    }
}
