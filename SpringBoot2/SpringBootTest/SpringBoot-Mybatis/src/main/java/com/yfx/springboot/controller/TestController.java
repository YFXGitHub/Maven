package com.yfx.springboot.controller;

import com.yfx.springboot.dao.RecordMapper;
import com.yfx.springboot.entity.Record;
import com.yfx.springboot.entity.User;
import com.yfx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    RecordMapper recordMapper;

    @RequestMapping("/id")
    public User toid(){

        return userService.getById(1);
    }

    @RequestMapping("/add")
    public User toAdd(){
        User user = new User(null,"aaaaaaa","123","asdf@qq.com","12312332112");
        userService.add(user);
        return user;
    }

    @RequestMapping("/update")
    public User tuUpdate(){
        User user = userService.getById(21);
        user.setUname("AAAAAAA");
        user.setUpwd("11111");
        userService.update(user);
        return user;
    }
    @RequestMapping("/delete")
    public String todelete(){
        userService.delete(21);
        return "yes";
    }

    @RequestMapping("/rec")
    public Record toRecordId(){
        Record byId = recordMapper.getByid(1);
        return byId;
    }


}
