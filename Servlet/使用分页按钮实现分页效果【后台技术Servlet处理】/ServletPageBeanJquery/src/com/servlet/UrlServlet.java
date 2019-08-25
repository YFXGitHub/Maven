package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@WebServlet("/urlServlet")
public class UrlServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String page="1";
		//req.getParameter("page");  获取用户点击的页码！
		if(req.getParameter("page") != null) {
			page = req.getParameter("page");
		}
		
		System.out.println("urlServlet-----page:"+page);
		User u1 = new User(1, "李四1", "男", 23, "河南省郑州市");
		User u2 = new User(2, "李四2", "男", 13, "河南省郑州市");
		User u3 = new User(3, "丽丽", "男", 23, "河南省郑州市");
		User u4 = new User(4, "克里斯丁", "男", 53, "河南省郑州市");
		User u5 = new User(5, "淀粉", "男", 23, "河南省郑州市");
		User u6 = new User(6, "发过的", "男", 33, "河南省郑州市");
		User u7 = new User(7, "上的", "男", 43, "河南省郑州市");
		User u8 = new User(8, "革凡登圣", "男", 42, "河南省郑州市");
		User u9 = new User(9, "赶得上法", "男", 43, "河南省郑州市");
		User u10 = new User(10, "广东省", "男", 41, "河南省郑州市");
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		list.add(u5);
		list.add(u6);
		list.add(u7);
		list.add(u8);
		list.add(u9);
		list.add(u10);
	
		JsonObject obj = new JsonObject();
		JsonArray arr = new JsonArray();
	
		Gson gson = new Gson();
		
		//obj.put("pageCount", "110");
//		obj.addProperty("list", gson.toJson(list));
		//obj.addProperty("list", list.toString());
		System.out.println(obj);
		System.out.println(gson.toJson(list));
		
		resp.getWriter().write(gson.toJson(list));
	}
}

class User {
	private Integer id;
	private String name;
	private String sex;
	private Integer age;
	private String address;
	
	public User() {
		super();
	}
	public User(Integer id, String name, String sex, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", address=" + address + "]";
	}
	
}
