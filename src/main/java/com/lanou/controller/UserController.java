package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;


	//登录
	@RequestMapping("/login.do")
	public void login(User user1, HttpServletRequest request, HttpServletResponse response){
		User users=userService.finduNameAndPwd(user1);
		System.out.println(users);
		boolean result=false;
		if (users!=null){
			request.getSession().setAttribute("users",users);
			result=true;
		}
		System.out.println(result);
		FastJson_All.toJson(result,response);
	}

	//注册
	@RequestMapping("/shijiao.do")
	public void shijiao(User user,HttpServletResponse response){
		User user1= userService.finduName(user);
		boolean result=false;
		if (user1==null){

			result=true;
		}
		System.out.println(user1);
		FastJson_All.toJson(result,response);
	}

	@RequestMapping("/reg.do")
	public void reg(User user,HttpServletResponse response){
		boolean result=false;
		if (userService.adduNameAndPwd(user)){
			result=true;
		}
		FastJson_All.toJson(result,response);
	}
	//根据用户名修改个人信息
	@RequestMapping("/update.do")
	public void updateUser(User user,HttpServletRequest request,HttpServletResponse response){
		boolean result=false;
		request.getSession().getAttribute("users");
		 if (userService.updateUser(user)){
		 	result=true;
		 }

		FastJson_All.toJson(result,response);
	}
	//修改密码
	@RequestMapping("/findPwdByuName.do")
	public void findPwdByuNmae(User user,HttpServletResponse response){
		User user1= userService.finduPasswordByuName(user);
			String result="NO";
		if (user1.getuPassword().equals(user.getuPassword())){
			result ="OK"; //旧密码输入正确
		}
		System.out.println(user1);
		FastJson_All.toJson(result,response); //旧密码输入错误
	}
	//修改密码
	@RequestMapping("updatePwdByuName.do")
	public void updatePwdByuName(User user,HttpServletResponse response){
		boolean result=false;

		if (userService.updateUser(user)){
			result=true; //新密码修改密码成功
		}
		FastJson_All.toJson(result,response); //新密码修改失败
	}
	//查询用户所有信息
	@RequestMapping("/findUser.do")
	@ResponseBody
	public List<User> findUser(User user){

		List<User> user1= userService.findUser(user);
		return user1;

	}
}
