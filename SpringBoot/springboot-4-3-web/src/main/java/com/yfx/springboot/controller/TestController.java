package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {



    @RequestMapping("/test1")
    public String test1(){
        System.out.println("test1()........");
        return "login";
    }
}
