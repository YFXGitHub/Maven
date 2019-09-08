package com.yfx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yfx.entity.Orders;
import com.yfx.service.OrdersService;

@RestController
public class TestController {
	
	@Autowired
	private OrdersService ordersService;

	@RequestMapping("/like")
	@ResponseBody
	public String pagelist() {

		System.out.println(ordersService.like("猛犸"));
		return "yes";
	}
	
	
}
