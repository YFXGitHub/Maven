package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.model.Cls;
import com.service.ClsService;

@Controller
@RequestMapping("/cls")
public class ClsController {

	@Autowired
	private ClsService clsService;
	
	@RequestMapping("/findAll")
	public void FindAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("findAlll..........");
		
//		List<Cls> findAllCls = clsService.findAllCls();
//		for (Cls cls : findAllCls) {
//			System.out.println(cls);
//		}
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//select * from userinfo limit ((page - 1)*limit),limit;    分页主要语句
		int page = (Integer.parseInt(request.getParameter("page")) - 1)* Integer.parseInt(request.getParameter("limit"));
		List<Cls> findPageCls = clsService.findPageCls(page, Integer.parseInt(request.getParameter("limit")));
//		for (Cls cls : findPageCls) {
//			System.out.println(cls);
//		}
		
	     //   "data": res.rows.item //解析数据列表
		//此处要遵循Layui 的数据表格的固定格式！
		JsonObject obj1 = new JsonObject();
		obj1.addProperty("status", 200);
		obj1.addProperty("message", "");
		obj1.addProperty("total", clsService.findSize());
		JsonObject obj2 = new JsonObject();
		Gson gson = new Gson();
		obj2.add("item", gson.toJsonTree(findPageCls));
		obj1.add("rows", obj2);
		//System.out.println(obj1.toString());
		response.getWriter().write(obj1.toString());
		
	}
	
	@RequestMapping("/updateCls")
	public String UpdateCls(Cls cls) {
		System.out.println(cls);
		clsService.update(cls);
		
		return "clsList";
	}
	
	//执行异步单个删除
	@RequestMapping("/deleteCls")
	public void DeleteCls(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		System.out.println("delete---"+request.getParameter("cid"));
		try {
			clsService.delete(Integer.parseInt(request.getParameter("cid")));
			response.getWriter().write("yes");
		} catch (Exception e) {
			System.out.println("当前主键下拥有子数据，删除失败！");
			response.getWriter().write("no");
		}
		
		
	}
	
	@RequestMapping("deleteClsAll")
	public void DeleteClsAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");		// 将1,2,3,4,5,6,52 切割成数组并将，号去掉！
		String[] strs = uid.split(",");
		System.out.println("批量删除后台：");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
			clsService.delete(Integer.parseInt(strs[i]));
		}
		//response.sendRedirect("/clsList.jsp");
		response.getWriter().write("成功！");
	}
}
