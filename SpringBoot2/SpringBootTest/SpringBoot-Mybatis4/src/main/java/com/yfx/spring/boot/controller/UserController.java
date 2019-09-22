package com.yfx.spring.boot.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.yfx.spring.boot.model.User;
import com.yfx.spring.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String toLogin(@RequestParam("username") String name,
                          @RequestParam("password") String pwd,
                          Model model, HttpSession session){
        log.info("登录 {} ---{}",name,pwd);
        User byName = userService.findByName(name);
        if(byName != null && pwd.equals(byName.getUpwd())){
            session.setAttribute("user", byName);
            return "list";
        }
        model.addAttribute("msg", "用户名或密码有误！");
        return "index";
    }

    @RequestMapping("/register")
    public String toRegister(User user){
        user.setCreatetime(new Date());
        userService.add(user);
        log.info("注册： {}", user);
        return "index";
    }

    @GetMapping("/findAll")
    public String tufindAll(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("userList", all);
        log.info("用户列表 --{}", all);
        return "userList";
    }

    @GetMapping("/all")
    @ResponseBody           //返回json数据  vue.html
    public String tufindAll2(){
        List<User> all = userService.findAll();
        Gson gson = new Gson();
        log.info("用户列表返回json数据  --{}", gson.toJson(all));
        return gson.toJson(all);
    }

    @GetMapping("/pageList")
    @ResponseBody                   //返回到page.html
    public String topageList(int page){
        page = (page -1)* 2;
        log.info("分页列表  {}", page);
        List<User> users = userService.pageList(page, 2);
        Gson gson = new Gson();
        log.info("-----{}",gson.toJson(users));
        return gson.toJson(users);
    }

    @GetMapping("/delete/{id}")
    public String toDelete(@PathVariable int id){
        log.info("删除 --{}", id);
        userService.delete(id);
        return "redirect:/user/userList";
    }
}
