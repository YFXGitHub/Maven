package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.model.Cls;
import com.model.Stu;
import com.service.ClsService;
import com.service.StuService;

@Controller
@RequestMapping("/stu")
public class StuController {

	@Autowired
	private StuService stuService;
	@Autowired
	private ClsService clsService;
	
	@RequestMapping("/findAll")
	public void FindAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		//select * from userinfo limit ((page - 1)*limit),limit;    分页主要语句
		page = (page - 1)*limit;
		List<Stu> findAllStuPage = stuService.findAllStuPage(page, limit);
		ArrayList list = new ArrayList<>();
		for (Stu stu : findAllStuPage) {
			//System.out.println(stu);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sid", stu.getSid());
			map.put("sname", stu.getSname());
			map.put("sex", stu.getSex());
			map.put("age", stu.getAge());
			map.put("cj", stu.getCj());
			map.put("cid", stu.getCls().getCid());
			map.put("cname", stu.getCls().getCname());
			list.add(map);
		}
		/**
		   "code": res.status, //解析接口状态
        "msg": res.message, //解析提示文本
        "count": res.total, //解析数据长度
        "data": res.rows.item //解析数据列表
		 */
		//此处要遵循Layui 的数据表格的固定格式！
		JsonObject obj1 = new JsonObject();
		obj1.addProperty("status", 200);
		obj1.addProperty("message", "");
		obj1.addProperty("total", stuService.findStuSize());
		JsonObject obj2 = new JsonObject();
		Gson gson = new Gson();
		obj2.add("item", gson.toJsonTree(list));
		obj1.add("rows", obj2);
		System.out.println(obj1.toString());
		response.getWriter().write(obj1.toString());
	}
	
	@RequestMapping("/deleteStu")
	public void DeleteStu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("deleteSts:"+request.getParameter("sid"));
		stuService.delete(Integer.parseInt(request.getParameter("sid")));
		
		response.getWriter().write("成功！");
	}
	
	//批量删除
	@RequestMapping("/deleteAllStu")
	public void DeleteAllStu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("批量删除：");
		String strs = request.getParameter("sid");
		String[] arrs = strs.split(",");
		for (int i = 0; i < arrs.length; i++) {
			//System.out.println(arrs[i]);
			stuService.delete(Integer.parseInt(arrs[i]));
		}
		response.getWriter().append("<script language='javascript'>window.location.href='stuList.jsp'</script>");
		
	}
	
	//查询班级 Cls  列表 用于填充select下拉框
	@RequestMapping("/selectCls")
	public void selectCls(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Cls> findAllCls = clsService.findAllCls();
		System.out.println(findAllCls);
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(findAllCls));
	}
	
	@RequestMapping("/updateStu")
	public String UpdateStu(Stu stu) {
		System.out.println("updateStu:"+stu);
		stuService.udpate(stu);
		return "stuList";
	}
}
