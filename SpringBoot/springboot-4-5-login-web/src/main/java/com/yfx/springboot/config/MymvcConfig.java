package com.yfx.springboot.config;

import com.yfx.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration  //此注解： 表示此类是一个配置类，SpringMVC
public class MymvcConfig extends WebMvcConfigurationSupport {

    //配置访问路径 和 返回的页面模板
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/oreder").setViewName("orders");
        registry.addViewController("/list").setViewName("bootstrapList");  // 登录成功的页面
    }

    //配置静态访问资源
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
      //  registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }

    //配置拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        // {/**} : 表示拦截所有请求, .excludePathPatterns()； 除去哪些路径 不拦截！
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login.html", "/user/login");
    }
}
