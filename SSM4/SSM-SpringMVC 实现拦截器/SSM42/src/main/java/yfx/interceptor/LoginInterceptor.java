package yfx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("进入拦截器。。。。。。。。。。");
		
		//获取请求路径
		String path = request.getRequestURI();
		System.out.println("请求路径为："+path);
		HttpSession session = request.getSession();
		//判断用户是否登录
		if(session.getAttribute("login") != null) {
			return true;
		}
		response.sendRedirect("/index.jsp");
		return false;
	}
	
}
