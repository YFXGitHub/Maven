package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String test(){

        return "hello World!";
    }

    @RequestMapping("/test1")
    public String test1(Map<String, Object> map){
        System.out.println("test1");
        map.put("a", "<h1>你好！</h1>");
        map.put("b", Arrays.asList("aaa", "bbb", "ccc"));
        // Ctrl + f  查找替换快捷键！   Ctrl + Shift + t 搜索类名文件
        return "home";
    }
}
