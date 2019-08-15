package com.yfx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfx.entity.Userinfo;
import com.yfx.service.UserinfoService;

@Controller
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping("/findAll")
	public String toUserinfoFindAll() {
		List<Userinfo> findAll = userinfoService.findAll();
		System.out.println(findAll);
		return "index";
	}
	
	
}
