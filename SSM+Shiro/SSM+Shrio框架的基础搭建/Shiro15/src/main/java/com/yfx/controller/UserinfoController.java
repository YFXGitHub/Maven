package com.yfx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfx.entity.Userinfo;
import com.yfx.service.UserinfoService;

@Controller
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping("/userinfoFindAll")
	public String toUserinfoFindAll() {
		List<Userinfo> findAll = userinfoService.findAll();
		System.out.println(findAll);
		return "index";
	}
}
