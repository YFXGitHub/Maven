package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

//登录
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String name, @RequestParam("password") String pwd,
                        Map<String, Object> map, HttpSession session){
        System.out.println("进入login();............"+name+"--"+pwd);
        if(!StringUtils.isEmpty(name) && "123".equals(pwd)){
            //验证成功！  且不让它再次提交表单 ， 使用重定向
            System.out.println("验证成功！");
            session.setAttribute("login", name);
            return "redirect:/list";
        }else{
            //验证失败！
            System.out.println("验证失败！");
            map.put("msg", "用户名或密码有误！");
            return "login";
        }
    }
}
