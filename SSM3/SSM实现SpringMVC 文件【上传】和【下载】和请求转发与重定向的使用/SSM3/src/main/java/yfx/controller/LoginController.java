package yfx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import yfx.model.Userinfo;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/test1")
	public String Test1(Userinfo user, Model model) {
		System.err.println("进入登录Test1()...........");
		System.out.println(user);
		model.addAttribute("user", user);
		return "forward:test2";  	//跳到Test2();  方法中在返回jsp页面！
		//return "forward:test2"; 请求转发	  能携带request值！
		//return "redirect:test2"; 重定向	 不能携带request值！
	}
	
	@RequestMapping("/test2")
	public String Test2() {
		System.out.println("Test2()............");
		return "yes";
	}
	
}
