package com.yfx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yfx.model.R;
import com.yfx.model.Userinfo;
import com.yfx.service.UserinfoService;

@Controller
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	
	//查询分页数据
	@RequestMapping("/pagelist")
	public void PageList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("进入分页后台123。。。");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("page:"+request.getParameter("page")+"---limit:"+request.getParameter("limit"));
		int page = (Integer.parseInt(request.getParameter("page")) - 1)* 10;		//计算页数
		System.out.println(page);
		List<Userinfo> findPage = userinfoService.findPage(page, 10);   //page 表示要显示的第几页， 10 表示每页10条数据！
		//System.out.println(findPage);
		// "code": res.status, //解析接口状态
	      //  "msg": res.message, //解析提示文本
	      //  "count": res.total, //解析数据长度
	     //   "data": res.rows.item //解析数据列表
		JsonObject obj = new JsonObject();
		obj.addProperty("status", 200);
		obj.addProperty("message", "");
		obj.addProperty("total", userinfoService.findAllSize());  //获取数据长度
		
		Gson gson = new Gson();
		JsonObject obj2 = new JsonObject();
		obj2.add("item", gson.toJsonTree(findPage));
		obj.add("rows", obj2);
		System.out.println( gson.toJsonTree(findPage).toString());
		System.out.println(obj.toString());
		response.getWriter().write(obj.toString());
		
	}
	
	
	// -----------------------------------------------------------------------  \\
	
	@RequestMapping("/list")
	public void ListfindAll(HttpServletResponse response) {
		//System.out.println("进入后台查询所有数据。。。。");
		
		R r = new R();
		r.setCode(0);
		r.setMsg("");
		r.setCount(500);
		
		List<Userinfo> findAll = userinfoService.findAll();
		r.setData(findAll);
		//System.out.println(findAll);
		
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		String json = gson.toJson(r);
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/update")
	public String AddTest(Userinfo info) {
		System.out.println("进入修改");
		System.out.println(info);
		userinfoService.update(info);;
		
		return "redirect:/list.jsp";    //修改完成后，返回当前列表
	}
	
	@RequestMapping("/delete")
	public void DeleteTest(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		System.out.println("进入删除！");
		try {
			request.setCharacterEncoding("utf-8");
			System.out.println(request.getParameter("uid"));
			response.setCharacterEncoding("utf-8");
			
			boolean isFlag = userinfoService.delete(Integer.parseInt(request.getParameter("uid")));
			if(isFlag) {
				response.getWriter().write("1");
			}else {
				response.getWriter().write("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// -----------------------------------------  list2.jsp 中的功能如下   ------------------------------------ \\
	@RequestMapping("/update2")
	public String AddTest2(Userinfo info) {
		System.out.println("进入修改");
		System.out.println(info);
		userinfoService.update(info);;
		
		return "redirect:/list2.jsp";    //修改完成后，返回当前列表
	}
	
	@RequestMapping("/delete2")
	public void DeleteTest2(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		System.out.println("进入删除！");
		try {
			request.setCharacterEncoding("utf-8");
			System.out.println(request.getParameter("uid"));
			response.setCharacterEncoding("utf-8");
			
			boolean isFlag = userinfoService.delete(Integer.parseInt(request.getParameter("uid")));
			if(isFlag) {
				response.getWriter().write("1");
			}else {
				response.getWriter().write("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
