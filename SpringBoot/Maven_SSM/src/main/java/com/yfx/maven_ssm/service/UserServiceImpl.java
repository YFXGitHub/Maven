package com.yfx.maven_ssm.service;

import com.yfx.maven_ssm.dao.UserMapper;
import com.yfx.maven_ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserAll() {
        return userMapper.findUserAll();
    }

    @Override
    public User findUserByName(String uname) {
        return userMapper.findUserByName(uname);
    }
}
