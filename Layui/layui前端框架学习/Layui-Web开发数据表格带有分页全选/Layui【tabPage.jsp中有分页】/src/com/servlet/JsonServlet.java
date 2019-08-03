package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.model.Userinfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JsonServlet
 */
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("进入/jsonServlet");
		
//		Userinfo info = new Userinfo(1, "拉斯", "23", "男");
//		JSONObject.fromObject(info);
//		System.out.println(JSONObject.fromObject(info).toString());
		
		ArrayList<Userinfo> list = new ArrayList<>();
		list.add(new Userinfo(1, "拉斯", "23", "男"));
		list.add(new Userinfo(2, "老师", "23", "女"));
		System.out.println(JSONArray.fromObject(list).toString());
		response.getWriter().write(JSONArray.fromObject(list).toString());
		
	}

}
