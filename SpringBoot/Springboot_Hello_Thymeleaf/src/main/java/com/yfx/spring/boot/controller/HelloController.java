package com.yfx.spring.boot.controller;

import com.yfx.spring.boot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toHello(Model model){

        User user = new User("lili");
        model.addAttribute("name", user.getUsername());
        return "index";
    }
}
