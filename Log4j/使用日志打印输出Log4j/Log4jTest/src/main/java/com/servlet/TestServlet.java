package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	//这样的话在每个需要日志输入的类下都要定一个Logger
	private static final Logger logger = LoggerFactory.getLogger(TestServlet.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "lkwejrlsadf--------";
		String[] str = {"a","b","wesd","we","gs","sg","f","df","s"};
		System.out.println("testSERVLET.......");
		logger.info("info..............");
		logger.debug("debug.........");
		logger.warn("warn...............");
		logger.error("error............");
		
		logger.info("info is {}", msg);
		for (int i = 0; i < str.length; i++) {
			logger.info("info is : {}", str[i]);
		}
		resp.sendRedirect("index.jsp");
	}

}
