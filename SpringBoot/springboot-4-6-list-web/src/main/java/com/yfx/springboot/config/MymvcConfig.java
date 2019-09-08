package com.yfx.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

// @Configuration  : 这是一个配置类
@Configuration
public class MymvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //配置访问路径  和 返回页面模板
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/list").setViewName("bootstrapList");

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置默认静态资源
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }
}
