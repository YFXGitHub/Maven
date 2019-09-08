package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordConroller {

    @ResponseBody     // 此注解： 将返回值写给浏览器
    @RequestMapping("/hello")
    public String Test(){

        return "Hello World Quick";
    }
}
