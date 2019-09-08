package com.yfx.springboot.controller;

import com.yfx.springboot.entity.User;
import com.yfx.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/userbyid/{id}")
    public User toFindById(@PathVariable("id") int id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/usersave")
    public User toSave(User user){
        User save = userRepository.save(user);
        return save;
    }
}
