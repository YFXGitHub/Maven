package com.yfx.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer         //开启EurekaServer 注册中心服务端
public class SpringcloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaApplication.class, args);
    }

}
