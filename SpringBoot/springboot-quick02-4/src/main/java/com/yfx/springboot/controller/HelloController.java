package com.yfx.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

   // @Value("${person.name}")   //此注解： 可获取application.properties/yml中的值
    private String name;

    @ResponseBody               // 此注解： 可使返回值赋予到浏览器的页面上！
    @RequestMapping("/hello")
    public String Test(){

        return "Hello World"+name;
    }
}
