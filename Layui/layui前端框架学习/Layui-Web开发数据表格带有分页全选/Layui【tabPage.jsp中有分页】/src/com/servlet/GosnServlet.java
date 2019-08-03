package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.model.R;
import com.model.Userinfo;

/**
 * Servlet implementation class GosnServlet
 */
public class GosnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GosnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("进入/gsonServlet");
		
		R r = new R();
		r.setCode(0);
		r.setMsg("");
		r.setCount(500);
		
		List<Userinfo> list = new ArrayList<>(); 
		list.add(new Userinfo(1, "流口水", "12", "男"));
		list.add(new Userinfo(2, "拉萨点击", "22", "女"));
		list.add(new Userinfo(3, "了；阿斯地方", "32", "男"));
		list.add(new Userinfo(4, "ksladf", "32", "男"));
		list.add(new Userinfo(5, "kjasdl", "32", "男"));
		list.add(new Userinfo(6, "卡死的积分", "32", "男"));
		list.add(new Userinfo(7, "卡士大夫", "42", "男"));
		list.add(new Userinfo(8, "拉萨的积分", "32", "男"));
		list.add(new Userinfo(9, "历史地看", "32", "男"));
		list.add(new Userinfo(10, "拉伸的开发", "22", "男"));
		list.add(new Userinfo(11, "的看法", "32", "男"));
		r.setData(list);
		
		Gson gson = new Gson();
		String json = gson.toJson(r);
		System.out.println(json);
		response.getWriter().write(json);
		
		
		
	}

}
