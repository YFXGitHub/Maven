package com.yfx.springboot.repository;

import com.yfx.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承 org.springframework.data.jpa.repository.JpaRepository; 就可以进行增删改查  <T, ?> User 实体类， Integer 自增主键的类型
public interface UserRepository extends JpaRepository<User, Integer> {
}
