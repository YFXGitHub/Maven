package com.yfx.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 使用WebMvcConfigurationSupport 来扩展SpringMVC的功能
    @EnableWebMvc  此注解：关闭SpringMVC的自动配置 也包括 静态的访问资源！
 */
//@EnableWebMvc
@Configuration
public class MyConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //自定义访问路径 和 返回页面 ！
        registry.addViewController("/test").setViewName("index2");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源找不到的访问路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
      //registry.addResourceHandler("/**").addResourceLocations("classpath:/webjars/");
    }

    //所有的WebMvcConfigurationSupport 都会一起，运作！
//    @Bean   //将组件放入容器中
//    public WebMvcConfigurationSupport customWebMvcConfigurationSupport(){
//        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport() {
//            @Override
//            protected void addViewControllers(ViewControllerRegistry registry) {
//                //
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/login.html").setViewName("login");
//            }
//        };
//        return support;
//    }
}
