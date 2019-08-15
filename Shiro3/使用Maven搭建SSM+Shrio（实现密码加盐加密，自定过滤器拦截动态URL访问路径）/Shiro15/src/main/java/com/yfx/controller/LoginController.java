package com.yfx.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String toLogin(@RequestParam("name") String username, @RequestParam("pwd") String password) {
		System.out.println("登录后台， 用户名："+username+"--"+password);
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
}
