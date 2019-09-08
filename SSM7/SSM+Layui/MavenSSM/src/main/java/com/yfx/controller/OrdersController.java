package com.yfx.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yfx.entity.Orders;
import com.yfx.entity.Record;
import com.yfx.entity.User;
import com.yfx.service.OrdersService;
import com.yfx.service.RecordService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private RecordService recordService;
	
	//Springmvc 异步请求数据乱码 produces = {"text/html;charset=utf-8"}
	@RequestMapping(value="/findPage" ,produces = {"json/html;charset=utf-8"})
	@ResponseBody
	public String tofindPage(int page, int limit) {
		logger.info("info -- {} ---{}", page, limit);
		int pages = (page - 1)* 10;		//计算页数
		List<Orders> findPage = ordersService.findPage(pages, limit);
		JSONObject obj = new JSONObject();
		obj.put("status", 200);
		obj.put("message", "");
		obj.put("total", ordersService.countSize());
		JSONObject obj2 = new JSONObject();
		obj2.put("item", JSONArray.toJSON(findPage));
		obj.put("rows", obj2);
		logger.info("info  : {}", obj.toJSONString());
		
		return obj.toJSONString();
	}
	
	@RequestMapping("/update")
	public String toupdate(Orders order, HttpSession session) {
		User u = (User)session.getAttribute("user");
		logger.info("info  update  -- {}", order);
		ordersService.update(order);
		
		Record record = new Record(u.getUname(), "修改订单");
		recordService.add(record);
		return "ordersList";
	}
	
	@RequestMapping("/add")
	public String toAdd(Orders order, HttpSession session) {
		User u = (User)session.getAttribute("user");
		logger.info("info  add  -- {}", order);
		ordersService.add(order);
		
		Record record = new Record(u.getUname(), "添加订单");
		recordService.add(record);
		return "ordersList";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String todelete(int oid, HttpSession session) {
		User u = (User)session.getAttribute("user");
		logger.info("info  delete  -- {}", oid);
		ordersService.delete(oid);
		
		Record record = new Record(u.getUname(), "删除订单");
		recordService.add(record);
		return "1";
	}
}
