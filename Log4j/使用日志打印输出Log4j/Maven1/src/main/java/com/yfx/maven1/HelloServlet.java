package com.yfx.maven1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] str = {"321","231","132","222","111","333","312","213","321","123"};
        logger.info("info.................");
        logger.error("error..................");
        System.out.println("Hello World Servlet...............");
        for (int i = 0; i <str.length ; i++) {
            logger.info("info is {}", str[i]);
            //{}指的是占位符  logger.info("info is {}", str[i]);  =  logger.info("info is : "+ str[i]); +：就代表new 了一个对象，若大范围的应用就操成了资源的损耗！
        }
        resp.sendRedirect("login.jsp");
    }
}
