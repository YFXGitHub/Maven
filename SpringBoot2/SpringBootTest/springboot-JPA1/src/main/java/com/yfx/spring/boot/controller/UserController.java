package com.yfx.spring.boot.controller;

import com.yfx.spring.boot.dao.UserDAO;
import com.yfx.spring.boot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDAO userDAO;

    //登录
    @PostMapping("/login")
    public String toLogin(@RequestParam("username") String name, @RequestParam("password") String pwd, HttpSession session){
        logger.info("login ---{} -- {}", name, pwd);
        User byName = userDAO.getByName(name);
        logger.info("login ---{}", byName);
        //判断不为空
        if(!StringUtils.isEmpty(byName)){
            if(byName.getPwd().equals(pwd)){
                session.setAttribute("user", byName);
                return "success";
            }
        }
        return "index";
    }

    //注册
    @PostMapping("/register")
    public String toRegister(User user){
        user.setCreatetime(new Date());
        logger.info("register ---{}", user);
        userDAO.save(user);
        return "index";
    }

    //数据列表
    @GetMapping("/findAll")
    public String toFindAll(Model model){
        List<User> all = userDAO.findAll();
        logger.info("findAll ---{}", all);
        model.addAttribute("userList", all);
        return "userList";
    }

    //修改之前
    @GetMapping("/updatePre/{id}")
    public String toUpdatePre(@PathVariable("id") Integer id, Model model){
        logger.info("updatepre ---{}", id);
        User user = userDAO.getOne(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    //修改
    @PostMapping("/update")
    public String toUpdate(User user){
        logger.info("update ---{}", user);
        userDAO.update(user);
        return "redirect:findAll";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String toDelete(@PathVariable("id") Integer id){
        logger.info("delete ---{}", id);
        userDAO.deleteById(id);
        return "redirect:/user/findAll";
    }

    @GetMapping("/pageList")
    @ResponseBody
    public List<User> toPageList(int page, int size){
        Sort sort = new Sort(Sort.Direction.ASC, "id");  //DESC降序  ASC升序
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<User> datas = userDAO.findAll(pageable);
        int totalElements = (int) datas.getTotalElements(); //总条数
        int totalPages =  datas.getTotalPages(); // 总页数
        List<User> content = datas.getContent(); // 数据列表
        return content;
    }
}
