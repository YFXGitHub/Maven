package com.yfx.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yfx.entity.Record;
import com.yfx.entity.User;
import com.yfx.service.RecordService;
import com.yfx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private RecordService recordService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public String tofindAll(){
		logger.info("info  : {}", userService.findByname("root"));
		return JSONArray.toJSON(userService.findAll()).toString();
	}
	
	@RequestMapping("/pagelist")
	@ResponseBody
	public String topagelist(int page, int limit){
		logger.info("info  : {} --- {}", page, limit);
		
		int pages = (page - 1)* 10;		//计算页数
		List<User> findPage = userService.findPage(pages, limit);
		JSONObject obj = new JSONObject();
		obj.put("status", 200);
		obj.put("message", "");
		obj.put("total", userService.countSize());
		JSONObject obj2 = new JSONObject();
		obj2.put("item", JSONArray.toJSON(findPage));
		obj.put("rows", obj2);
		logger.info("info  : {}", obj.toJSONString());
		//layui 分页的固定json返回格式：{"total":1,"message":"","rows":{"item":[{"uid":1,"uname":"root","phone":"12332112332","emial":"234234@qq.com","upwd":"123"}]},"status":200}
		return obj.toJSONString();
	}
	
	@RequestMapping("/update")
	public String toupdate(User user,  HttpSession session) {
		User u = (User)session.getAttribute("user");
		logger.info("info : update  -- {}  person{} ", user, u.getUname());
		userService.update(user);
		
		Record record = new Record(u.getUname(), "修改用户");
		recordService.add(record);
		 return "userList";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String todelete(int uid,  HttpSession session) {
		User u = (User)session.getAttribute("user");
		logger.info("info : delete  -- {}     person:{}", uid, u.getUname());
		userService.delete(uid);
		
		Record record = new Record(u.getUname(), "删除用户");
		recordService.add(record);
		return "1";
	}
	
	//登录
	@RequestMapping("/login")
	public String toLogin(@RequestParam("username") String name,
			@RequestParam("password") String pwd,  HttpSession session){
		logger.info("info : login  -- {} ----{}", name, pwd);
		User byuser = userService.findByname(name);
		//判断用户存在，且密码正确
		if(byuser != null && pwd.equals(byuser.getUpwd())) {
				session.setAttribute("user", byuser);
				return "index";
		}
		return "login";
	}
	
	
	//注册
	@RequestMapping("/register")
	public String toRegister(User user) {
		logger.info("info : register  -- {}", user);
		userService.reg(user);
		return "login";
	}
	
	//修改密码
	@RequestMapping("/updatePwd")
	@ResponseBody
	public String toupdatePwd(User user, String pwd2) {
		User result = userService.findById(user.getUid());
		if(result != null) {
			if(user.getUpwd().equals(result.getUpwd())) {
				user.setUpwd(pwd2);
				userService.update(user);
				return "yes";
			}
		}
		logger.info("info : updatePwd {} --{}", user, pwd2);
		return "no";
	}
	
}
