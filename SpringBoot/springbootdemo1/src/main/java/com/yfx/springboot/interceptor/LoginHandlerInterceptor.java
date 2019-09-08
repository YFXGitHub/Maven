package com.yfx.springboot.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session中是否有用户的登录信息，并判断
        Object login = request.getSession().getAttribute("login");
        if(StringUtils.isEmpty(login)){
            request.getSession().setAttribute("msg", "用户权限不足！");
            request.getRequestDispatcher("login.html").forward(request, response);
            return false;
        }else{
            return  true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
