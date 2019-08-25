package com.yfx.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yfx.entity.User;
import com.yfx.service.UserService;

/**
 * 登录验证 注册功能 
 * @author Administrator
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userSerivce;
	
	@RequestMapping("/login")
	public String toLogin(@RequestParam("username") String name, @RequestParam("password") String pwd) {
		System.out.println("登录的用户名："+name+"--"+pwd);
		Subject subject = SecurityUtils.getSubject();
		//判断用户是否已登录
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
			try {
				subject.login(token);
				subject.getSession().setAttribute("loginName", token.getUsername());
			} catch (AuthenticationException e) {
				// 验证失败
				return "login";
			}
		}
		return "home";
	}
	
	@RequestMapping("/register")
	public String toRegister(User user) {
		//System.out.println(user);
		 //随机加盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;  //累计的次数
        String algorithmName = "md5"; //加密的方式
         //开始加盐，在加密
        String encodedPassword = new SimpleHash(algorithmName,user.getPassword(),salt,times).toString();
		user.setPassword(encodedPassword);
		user.setSalt(salt);
		System.out.println(user);
		userSerivce.save(user);
        return "login";
	}
}
