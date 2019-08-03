package yfx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import yfx.model.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String LoginTesT(User user, Model model,HttpSession session) {
		System.out.println("进入后台");
		System.out.println(user);
		model.addAttribute("user", user);
		session.setAttribute("login", user);
		return "forward:list";
	}
	
	@RequestMapping("/list")
	public String listTest() {
		System.out.println("进入listTest().........");
		
		return "list";
	}
}
