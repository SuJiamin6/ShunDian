package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.History;
import com.lanou.entity.User;
import com.lanou.service.GoodsTypeService;
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

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsTypeService goodsTypeService;


	//登录
	@RequestMapping("/login.do")
	@ResponseBody
	public boolean login(User user1, HttpServletRequest request){
		User users=userService.finduNameAndPwd(user1);
		System.out.println(users);
		if (users!=null){
			request.getSession().setAttribute("users",users);
//			调出历史记录放入session中
		    String username	= user1.getuName();
			List<History> history = goodsTypeService.findHistory(username);
			request.getSession().setAttribute("History",history);
			return true;
		}
		return false;
	}

	//注册
	@RequestMapping("/shijiao.do")
	@ResponseBody
	public boolean shijiao(User user){
		User user1= userService.finduName(user);
		boolean result=false;
		if (user1==null){

			return true;
		}
		System.out.println(user1);
		return result;
	}

	@RequestMapping("/reg.do")
	@ResponseBody
	public boolean reg(User user){
		boolean result=false;
		if (userService.adduNameAndPwd(user)){
			return  true;
		}
		return result;
	}
	//根据用户名修改个人信息
	@RequestMapping("/update.do")
	@ResponseBody
	public boolean updateUser(User user,HttpServletRequest request){
		boolean result=false;
		request.getSession().getAttribute("users");
		 if (userService.updateUser(user)){
		 	return true;
		 }

		return false;
	}
	//修改密码
	@RequestMapping("/findPwdByuName.do")
	@ResponseBody
	public String findPwdByuNmae(User user){
		User user1= userService.finduPasswordByuName(user);

		if (user1.getuPassword().equals(user.getuPassword())){
			return "OK"; //旧密码输入正确
		}
		System.out.println(user1);
		return "NO"; //旧密码输入错误
	}
	//修改密码
	@RequestMapping("updatePwdByuName.do")
	public boolean updatePwdByuName(User user,HttpServletRequest request){
		boolean result=false;

		if (userService.updateUser(user)){
			return true; //新密码修改密码成功
		}
		return false;  //新密码修改失败
	}
	//查询用户所有信息
	@RequestMapping("/findUser.do")
	//@ResponseBody
	public void findUser(User user,HttpServletResponse response){

		List<User> user1= userService.findUser(user);
		//return user1;
		FastJson_All.toJson(user1,response);
	}
}
