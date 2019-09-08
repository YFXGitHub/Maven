package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test1")
    public String test1(){

        return "Hello World!";
    }

    @RequestMapping("/test2")
    public String test2(Map<String, Object> map){
        map.put("a", "Hello");
        map.put("b", "<h1>Hello</h1>");
        map.put("c", Arrays.asList("aa","bb","cc"));
        return "home";
    }
}
