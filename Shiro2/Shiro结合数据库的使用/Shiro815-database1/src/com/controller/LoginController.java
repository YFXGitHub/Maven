package com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String toLogin(@RequestParam("name") String username, @RequestParam("pwd") String password) {
		System.out.println("登录的帐号："+username+"--密码："+password);
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				subject.login(token);
			} catch (Exception e) {
				// 验证失败
				return "login";
			}
		}
		return "success";
	}
	
	@RequiresPermissions("listProduct")		//查询当前用户是否有listProduct 这个权限！有则执行，否则跳转404页面！
	@RequestMapping("/product")
	public String toProduct() {
		System.out.println("查询所有商品，执行成功！");
		return "success";
	}
	
	@RequiresPermissions("listOrder")
	@RequestMapping("/orders")
	public String toOrders() {
		System.out.println("查询所有订单， 执行成功！");
		return "success";
	}
}
