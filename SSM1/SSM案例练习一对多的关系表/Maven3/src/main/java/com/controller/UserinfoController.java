package com.controller;

import java.util.List;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Userinfo;
import com.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping("/findall")
	public String FindAll(Model model) {
		//System.out.println("UserinfoFindall.............");
		List<Userinfo> findAllUserinfo = userinfoService.findAllUserinfo();
		model.addAttribute("userinfoList", findAllUserinfo);
//		for (Userinfo info : findAllUserinfo) {
//			System.out.println(info);
//		}
		return "userinfoList";
	}
	
	@RequestMapping("/updatePre")
	public String UpdatePre(int uid, Model model) {
		System.out.println("updatePre:"+uid);
		Userinfo findUserinfoById = userinfoService.findUserinfoById(uid);
		model.addAttribute("userinfo", findUserinfoById);
		//System.out.println(findUserinfoById);
		
		return"userinfoUpdate";
	}
	
	@RequestMapping("/update")
	public String Update(Userinfo userinfo) {
		//System.out.println(userinfo);
		userinfoService.update(userinfo);
		return "forward:findall";
	}
	
	@RequestMapping("/delete")
	public String Delete(int uid) {
		userinfoService.delete(uid);
		return "forward:findall";
	}
}
