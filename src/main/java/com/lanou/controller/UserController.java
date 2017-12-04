package com.lanou.controller;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;


	//登录
	@RequestMapping("/login.do")
	public boolean login(User user1){
		User users=userService.finduNameAndPwd(user1);
		boolean result=false;
		if (users!=null){

			return true;
		}
		System.out.println(result);
		return false;
	}

	//注册
	@RequestMapping("/reg.do")
	public boolean reg(User user){
		User user1= userService.finduName(user);
		boolean result=false;
		if (user1==null){
			result=userService.adduNameAndPwd(user);
			return true;
		}
		return result;
	}

}
