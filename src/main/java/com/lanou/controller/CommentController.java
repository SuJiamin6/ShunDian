package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Comments;
import com.lanou.entity.DiZhi;
import com.lanou.entity.User;
import com.lanou.service.CommentService;
import com.lanou.service.DiZhiService;
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
public class CommentController {

   @Autowired
   private CommentService commentService;

   @RequestMapping("addComment.do")
   public void addComment(Comments comments, HttpServletResponse response, HttpSession session){
//      User user=(User) session.getAttribute("users");
//     Integer user_id= user.getuId();
//      System.out.println(user_id);
//     comments.setUser_id(user_id);
     boolean result=false;
     if (commentService.addComment(comments)){
        result=true;
     }
      FastJson_All.toJson(result,response);
   }
}
