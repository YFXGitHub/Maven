package com.yfx.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     //开启EurekaClient  客户端
public class SpringcloudServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
    }

}
