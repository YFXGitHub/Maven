package com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String toLogin(String name, String pwd) {
		System.out.println(name+"--"+pwd);
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
			try {
				subject.login(token);
			} catch (Exception e) {
				// 验证失败
				return "login";
			}
		}
		return "success";
	}
	
	@RequiresRoles("root")
	@RequestMapping("/root")
	public String toRoot() {
		System.out.println("root权限的私有方法访问成功！");
		return "success";
	}
	
	/* 使用if 判断 用户拥有的角色
	 	@RequestMapping("/root")
		public String toRoot() {
			System.out.println("toRoot().......");
			Subject subject = SecurityUtils.getSubject();
			if(subject.hasRole("root")) {
				//有权限
				System.out.println("当前用户拥有root角色！");
			}else {
				//无权限
				System.out.println("没有权限！");
				return "error";
			}
			return "success";
		}
	 */
	
	
//	@RequestMapping("/unauthorized")
//	public String unauthorized() {
//		return "/404-2";
//	}

}

/**/
