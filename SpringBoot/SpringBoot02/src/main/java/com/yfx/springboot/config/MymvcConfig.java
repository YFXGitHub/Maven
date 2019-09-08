package com.yfx.springboot.config;

import com.yfx.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 此类是一个配置类，因为标注有@Configuration 就是一个配置类
 */
@Configuration
public class MymvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //配置访问路径 和 返回的页面模板
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/list").setViewName("bootstrapList");

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态访问资源路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    //配置拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //  {/**} 表示拦截所有资源， excludePathPatterns ：表示哪些请求不拦截！
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login.html", "/user/login");
    }

}
