package com.yfx.springbootjpa.controller;

import com.yfx.springbootjpa.dao.UserDAO;
import com.yfx.springbootjpa.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/add")
    public User toAdd(User user){

        return userDAO.save(user);
    }

    @GetMapping("/findAll")
    public String tofindAll(Model model){
        logger.info("info findAll ---");
        List<User> all = userDAO.findAll();
        model.addAttribute("userList", all);
        return "userList";
    }

    @PostMapping("/login")
    public String toLogin(@RequestParam("username") String name, @RequestParam("password") String pwd, HttpSession session){
        User byName = userDAO.getByName(name);
        if(byName != null && byName.getPwd().equals(pwd)){
            logger.info("info login ---{}", byName);
            //将验证成功的用户信息暂存到session 中
            session.setAttribute("name", byName.getName());
            return "success";     //重定向到MymvcConfig 配置类中的配置返回html页面！
        }
        logger.info("info login----登录失败！");
        return "index";
    }

    //修改之前的查看
    @GetMapping("/updatePre/{id}")
    private String toupdatePre(@PathVariable("id") Integer id , Model model){
        User byId = userDAO.getById(id);
        logger.info("info --updatePre---{} ---{}", id, byId);
        model.addAttribute("user", byId);

        return "userUpdate";
    }

    //修改
    @PostMapping("/update")
    public String toUpdate(User user){
        logger.info("info --update--{}", user);
        userDAO.save(user);
        return "redirect:findAll";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String todelete(@PathVariable("id") Integer id){
        logger.info("info --delete---{}", id);
        userDAO.deleteById(id);
        return "redirect:/user/findAll";
    }
}
