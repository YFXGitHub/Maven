package com.yfx.maven_ssm.dao;

import com.yfx.maven_ssm.model.User;

import java.util.List;

public interface UserMapper {

    //查询所有
    public List<User> findUserAll();

    //查询用户的当前信息
    public User findUserByName(String uname);
}
