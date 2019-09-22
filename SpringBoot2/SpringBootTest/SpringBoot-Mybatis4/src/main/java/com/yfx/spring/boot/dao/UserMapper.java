package com.yfx.spring.boot.dao;

import com.yfx.spring.boot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据用户名查询用户信息
    public User findByName(@Param("uname") String uname);
    //查询所有用户信息
    public List<User> findAll();
    //添加
    public void add(User user);
    //分页查询
    public List<User> pageList(@Param("page") int page, @Param("limit") int limit);
    //delete
    public void delete(@Param("uid") int uid);
}
