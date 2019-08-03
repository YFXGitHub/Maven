package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.Userinfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 连接数据库查询数据 以分页的形式显示
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private static final long serialVersionUID = 1L;
       
  
    public PageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("进入后台：");
		System.out.println("page:"+request.getParameter("page")+"---limit:"+request.getParameter("limit"));
		
		List list = new ArrayList<>();
		
		//连接JDBC 四个连接池
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/day1";
		String user = "root";
		String pwd = "a123";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			//select * from userinfo limit ((page - 1)*limit),limit;    分页主要语句
			int page = (Integer.parseInt(request.getParameter("page")) - 1)* 10;		//计算页数
			System.out.println("page::::::::"+page);
			pstm = conn.prepareStatement("select * from userinfo limit ?,10");
			pstm.setInt(1, page);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Userinfo info = new Userinfo();
				info.setUid(rs.getInt(1));
				info.setUname(rs.getString(2));
				info.setUsex(rs.getString(3));
				info.setUage(rs.getInt(4));
				info.setUaddress(rs.getString(5));
				list.add(info);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs   != null)
						rs.close();
					if(pstm != null)
						pstm.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		//System.out.println(list);
		
	
		// "code": res.status, //解析接口状态
	      //  "msg": res.message, //解析提示文本
	      //  "count": res.total, //解析数据长度
	     //   "data": res.rows.item //解析数据列表
		JSONObject obj = new JSONObject();
		obj.put("status", 200);
		obj.put("message", "");
		obj.put("total", 18);		//获取所有数据的条数！
		JSONObject obj2 = new JSONObject();
		obj2.put("item", JSONArray.fromObject(list));
		obj.put("rows", obj2);
		
		//System.out.println(obj.toString());
		response.getWriter().write(obj.toString());
		
	}

}
