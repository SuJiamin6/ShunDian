package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.History;
import com.lanou.entity.User;
import com.lanou.service.DiZhiService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DiZhiService diZhiService;
	@Autowired
	private GoodsTypeService goodsTypeService;

	//登录
	@RequestMapping("/login.do")

	public void login(User user1, HttpServletRequest request,HttpServletResponse response){
		User users=userService.finduNameAndPwd(user1);
		System.out.println(users);
		String result="false";
		if (users!=null){
			request.getSession().setAttribute("users",users);
			String username	= user1.getuName();
			List<History> history = goodsTypeService.findHistory(username);
			request.getSession().setAttribute("History",history);
			result= "true";
			result=username;
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

			result= true;
		}
		System.out.println(user1);
		FastJson_All.toJson(result,response);
	}

	@RequestMapping("/reg.do")

	public void reg(User user,HttpServletResponse response){
		boolean result=false;
		if (userService.adduNameAndPwd(user)){
			result =true;
		}
		FastJson_All.toJson(result,response);
	}
	//根据用户名修改个人信息
	@RequestMapping("/update.do")
	public void updateUser(@RequestParam("cityid") Integer[] param, User user, HttpServletResponse response,HttpSession session){
		session.setAttribute("cityid",param);
		List diZhis=new ArrayList();
		String diZhi=null;

		for(int i=0;i<param.length;i++){

			System.out.println(param[i]);
			diZhi=diZhiService.findSXQ(param[i]);
			diZhis.add(diZhi);
		}

		String strResult="";
		for (int i=0;i<diZhis.size();i++){
			strResult+=diZhis.get(i)+"/";
		}
		strResult=strResult.substring(0,strResult.length()-1);
		System.out.println(strResult);

		boolean result=false;
		String adress = strResult;
		user.setAddress(adress);
		if (userService.updateUser(user)){
			result= true;
		}
		FastJson_All.toJson(result,response);
	}
	//输入密码
	@RequestMapping("/findPwdByuName.do")
	public void findPwdByuNmae(HttpSession session,HttpServletResponse response){
		User user=(User) session.getAttribute("users");
		user.getuName();
		User user1= userService.finduPasswordByuName(user);
		String result="NO";
		if (user1.getuPassword().equals(user.getuPassword())){
			result= "OK"; //旧密码输入正确
		}
		System.out.println(user1);
		 //旧密码输入错误
		FastJson_All.toJson(result,response);
	}
	//修改密码  传入密码uPassword
	@RequestMapping("updatePwdByuName.do")
	public void updatePwdByuName(User user,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		User user1=(User)session.getAttribute("users");
		user.setuName(user1.getuName());
		boolean result=false;
		if (userService.updatePwd(user)){
			result= true; //新密码修改密码成功
		}
		  //新密码修改失败
		FastJson_All.toJson(result,response);
	}
	//查询用户所有信息 登陆后直接访问查询
	@RequestMapping("/findUser.do")
	//@ResponseBody
	public void findUser(HttpSession session,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String, Object>();
		User user=(User)session.getAttribute("users");

		String result= user.getuName();
		//Integer[] cityid=(Integer[]) session.getAttribute("cityid");

		//System.out.println(cityid);
		User user1= userService.findUser(result);

		map.put("user",user1);
		//map.put("cityid",cityid);
		FastJson_All.toJson(map,response);
	}
}
