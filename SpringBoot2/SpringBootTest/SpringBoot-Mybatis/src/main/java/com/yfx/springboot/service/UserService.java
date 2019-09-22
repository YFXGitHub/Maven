package com.yfx.springboot.service;


import com.yfx.springboot.entity.User;

public interface UserService {

    public User getById(Integer uid);

    public int add(User user);

    public int update(User user);

    public int delete(Integer uid);


}
