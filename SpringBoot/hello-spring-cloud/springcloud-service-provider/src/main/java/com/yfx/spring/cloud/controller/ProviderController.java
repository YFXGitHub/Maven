package com.yfx.spring.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {       //这是一个服务提供类

    @GetMapping("/service")
    public String toService(){

        return "Hello SpringCloud!";
    }
}
