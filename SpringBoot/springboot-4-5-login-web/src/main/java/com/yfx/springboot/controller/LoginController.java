package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

   // @RequestMapping( value = "/user/login", method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String test1(@RequestParam("username") String username,
                        @RequestParam("pwd") String pwd2,
                        Map<String, Object> map, HttpSession session){
        System.out.println("test1()...."+username+"---"+pwd2);
        if(!StringUtils.isEmpty(username) && "123".equals(pwd2)){
            System.out.println("验证成功！");  //防止表单再次提交， 此处采用重定向的方式 跳转
            session.setAttribute("login", username);        //验证成功，在session中放入用户名，用于在拦截器中判断是否登录？
            return "redirect:/list";
        }else{
            System.out.println("验证失败！");
            map.put("msg", "用户名或密码错误！");
            return "login";
        }
    }
}
