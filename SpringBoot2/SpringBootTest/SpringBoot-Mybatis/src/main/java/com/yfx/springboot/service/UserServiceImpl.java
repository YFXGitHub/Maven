package com.yfx.springboot.service;

import com.yfx.springboot.dao.UserMapper;
import com.yfx.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer uid) {
        return userMapper.getById(uid);
    }

    @Override
    public int add(User user) {
        userMapper.add(user);
        return 0;
    }

    @Override
    public int update(User user) {
        userMapper.update(user);
        return 0;
    }

    @Override
    public int delete(Integer uid) {
        userMapper.delete(uid);
        return 0;
    }


}
