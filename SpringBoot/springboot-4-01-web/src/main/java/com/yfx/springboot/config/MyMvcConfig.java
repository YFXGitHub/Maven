package com.yfx.springboot.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration  表示这是一个配置类
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/settingView").setViewName("success");
    }
}
