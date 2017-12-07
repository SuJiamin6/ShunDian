package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.DiZhi;
import com.lanou.service.DiZhiService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class DiZhiController {

   @Autowired
   private DiZhiService diZhiService;
    //查询地址
   @RequestMapping("/findDiZhi.do")
   public void findDiZhi(DiZhi diZhi, HttpServletResponse response){

      List<DiZhi> result= diZhiService.findDiZhi(diZhi);
      System.out.println(result);
      FastJson_All.toJson(result,response);

   }
}
