package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String name, @RequestParam("password") String pwd,
                        Map<String, Object> map, HttpSession session){
        //判断用户名 是否为空， 密码是否为123
        if(!StringUtils.isEmpty(name) && "123".equals(pwd)){
            System.out.println(name);
            session.setAttribute("loginName", name);  //验证成功， 在session中放入用户名。
            return "redirect:/list";
        }else{
            map.put("msg", "用户名或密码有误！");
            return "login";
        }
    }
}
