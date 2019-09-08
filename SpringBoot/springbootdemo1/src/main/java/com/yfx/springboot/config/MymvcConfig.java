package com.yfx.springboot.config;

import com.yfx.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//SpringMVC 配置文件
@Configuration
public class MymvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //配置访问路径  和  返回页面模板
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/list").setViewName("bootstrapList");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态访问资源templates
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }

    //配置拦截器
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login.html", "/user/login");
//    }
}
