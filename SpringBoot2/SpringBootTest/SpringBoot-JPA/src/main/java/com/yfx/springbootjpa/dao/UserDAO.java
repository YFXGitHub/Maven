package com.yfx.springbootjpa.dao;

import com.yfx.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//使用springboot JPA 就要继承Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    /**
     * 根据用户名获取当前用户的所有信息
     */
    User getByName(String name);

    /**
     * 根据用户ID获取当前用户的所有信息
     */
    User getById(Integer id);


}
