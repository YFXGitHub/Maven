package com.yfx.spring.boot.service;

import com.yfx.spring.boot.dao.UserMapper;
import com.yfx.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //根据用户名查询用户信息
    @Override
    public User findByName(String uname) {
        return userMapper.findByName(uname);
    }

    //查询所有用户信息
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    //添加
    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    //分页查询
    @Override
    public List<User> pageList(int page, int limit) {
        return userMapper.pageList(page, limit);
    }

    //删除
    @Override
    public void delete(int uid) {
        userMapper.delete(uid);
    }
}
