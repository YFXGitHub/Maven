package com.yfx.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfx.entity.User;
import com.yfx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userSerivce;
	
	//@RequiresRoles({"admin", "userInfoManager"})  这种方式为：用户同时拥有这个两个角色
	//属于user或者admin之一;修改logical为OR 即可
	@RequiresRoles(value={"admin","userInfoManager"},logical=Logical.OR)
	@RequestMapping("/userList")
	public String touserList(Model model){
		System.out.println("进入/userList。。。。。。。");
		List<User> findAll = userSerivce.findAll();
		model.addAttribute("userList", findAll);
		return "userList";
	}
	
	@RequiresPermissions("updateUserinfo")
	@RequestMapping("/userUpdate")
	public String toUserUpdate(){
		System.out.println("可执行修改！");
		return "redirect:userList";
	}
	
	@RequiresPermissions("deleteUserinfo")
	@RequestMapping("/userDelete")
	public String toUserDeate(){
		System.out.println("可执行删除！");
		return "redirect:userList";
	}
}
