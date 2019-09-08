package com.yfx.springboot.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器 在没有登录成功，不让访问任何页面
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断 用户是否登录成功！若session中没有用户名， 则没有登录成功。
        Object loginName = request.getSession().getAttribute("loginName");
        if(StringUtils.isEmpty(loginName)){
            request.getRequestDispatcher("login.html").forward(request, response);
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
