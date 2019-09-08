package com.yfx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yfx.service.DubboService;

//@Controller
@RestController
public class DubboController {

	@Reference
	DubboService dubboService;
	
	@RequestMapping("/name")
	//@ResponseBody   //返回json数据
	public String toGetName() {
		
		return dubboService.getName();
	}
	
	@RequestMapping("/test")
	public void toTest() {
		System.out.println("test");
	
	}
	
}
