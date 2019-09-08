package com.yfx.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@EnableWebMvc 此注解：所有的spirngmvc 的自动配置都会失效，连静态资源也失效！
@Configuration
public class MymvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/settingView").setViewName("success");
    }
}
