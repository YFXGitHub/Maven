package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordController {

    @ResponseBody       // 此注解： 将return 的返回值给jsp页面显示！
    @RequestMapping("/hello")
    public String Test(){
        return "Hello Word";
    }

}
