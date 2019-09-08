package com.yfx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String name, @RequestParam("pwd") String pwd,
                        Map<String, Object> map, HttpSession session){
        //判断帐号-不能为空、密码123
        if(!StringUtils.isEmpty(name) && "123".equals(pwd)){
            session.setAttribute("loginName", name);
            //验证成功！ 重定向到list页面
            return "redirect:/list";
        }else{
            map.put("msg", "帐号或密码有误！");
            return "login";
        }
    }

}
