package com.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.PersonDao;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String toLogin(@RequestParam("username") String name, @RequestParam("password") String pwd) {
		System.out.println("登录用户名："+name+"----"+pwd);
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				//验证失败
				return "login";
			}
		}
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String toList(Model model) {
		System.out.println("进入列表。。。。");
		PersonDao dao = new PersonDao();
		System.out.println(dao.getAll());
		model.addAttribute("list", dao.getAll());
		return "success";
	}
}
