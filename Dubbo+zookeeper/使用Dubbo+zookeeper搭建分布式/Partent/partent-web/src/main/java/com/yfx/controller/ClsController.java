package com.yfx.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yfx.model.Cls;
import com.yfx.service.ClsService;

@Controller
public class ClsController {

	@Reference
	private ClsService clsService;
	
	@RequestMapping(value="/cls", method=RequestMethod.GET, produces="text/json;charset=UTF-8")
	//(value="/cls", method=RequestMethod.GET, produces="text/json;charset=UTF-8")	解决中文乱码
	@ResponseBody
	public String toFindAll(){
		System.out.println(clsService.findAll().toString());
		
		return clsService.findAll().toString();
	}
	
}
