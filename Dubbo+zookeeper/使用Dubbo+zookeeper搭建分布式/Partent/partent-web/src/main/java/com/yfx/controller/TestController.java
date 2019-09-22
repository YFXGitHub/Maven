package com.yfx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yfx.service.TestService;

@RestController
public class TestController {
	
	@Reference
	TestService testService;
	
	@RequestMapping("/test")
	public String toTest() {
		
		return testService.getHello();
		//return "sadfasd";
	}

}
