package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String toLogin(@RequestParam("username") String name, @RequestParam("password") String pwd,
                          Map<String, Object> map, HttpSession session){
        System.out.println("登录用户名："+name+"---"+pwd);
        //判断帐号密码
        if(!StringUtils.isEmpty(name) && pwd.equals("123")){
            session.setAttribute("loginName", name);
            return "redirect:/list";
        }else{
            map.put("msg", "用户名或密码有误！");
            return "login";
        }
    }
}
