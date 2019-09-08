package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication          //此注解： 说明这是一个SpringBoot 应用
public class HelloWordMainApplication {

    //main(); 方法的快捷键  psvm
    public static void main(String[] args) {
        SpringApplication.run(HelloWordMainApplication.class, args);
    }
}
