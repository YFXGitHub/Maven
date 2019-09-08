package com.yfx.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient         //开启EurekaClient客户端
public class SpringcloudServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceConsumerApplication.class, args);
    }

}
