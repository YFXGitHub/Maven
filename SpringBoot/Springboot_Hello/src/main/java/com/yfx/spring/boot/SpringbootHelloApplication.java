package com.yfx.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
// 若不想使用自动配置数据源，就配置： @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootHelloApplication {

    @RequestMapping("/")
    public String toHello(){

        return "Hello World SpringBooot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloApplication.class, args);
    }

}
