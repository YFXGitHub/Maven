package com.yfx.springboot.config;

import com.yfx.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
    @Configuration  此注解： 指当前类就是一个配置类， 用来代替Spring 中的配置文件*.xml的.
    在配置文件中使用 <bean></bean>标签来添加组件
 */
@Configuration
public class MyappConfig {

    //将方法的返回值添加到容器中，容器中这个方法的默认返回值就是方法名（）
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean为容器中添加组件了！");
        return new HelloService();
    }
}
