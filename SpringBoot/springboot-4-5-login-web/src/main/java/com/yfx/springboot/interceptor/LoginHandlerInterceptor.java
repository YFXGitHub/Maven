package com.yfx.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器   idea 使用快捷键 实现接口的方法 Alt +Insert
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户登录成功的信息，若为空，则没有登录成功、没有登录！
        Object obj = request.getSession().getAttribute("login");
        if(obj == null){
            //未登录， 返回登录页面
            request.setAttribute("msg", "没有权限！");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }else{
            //登录
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
