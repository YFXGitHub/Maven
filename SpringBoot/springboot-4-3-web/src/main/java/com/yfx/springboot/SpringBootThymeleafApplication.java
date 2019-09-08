package com.yfx.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration      //
@SpringBootApplication  //
public class SpringBootThymeleafApplication extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry); 配置静态资源
     //registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates");
       // registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static");
    }
}
