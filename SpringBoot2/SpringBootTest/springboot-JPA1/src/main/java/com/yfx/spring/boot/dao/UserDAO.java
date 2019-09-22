package com.yfx.spring.boot.dao;

import com.yfx.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

//使用JPA 要继承JpaRepository
public interface UserDAO extends JpaRepository<User, Integer> {

    //根据用户名查询用户信息
   public User getByName(String name);

   //自定义修改方法
    @Modifying
    @Transactional
    @Query("update User u set " +
            "u.name = CASE WHEN :#{#user.name} is null then u.name else :#{#user.name} end ," +
            "u.pwd = CASE WHEN :#{#user.pwd} is null then u.pwd else :#{#user.pwd} end ," +
            "u.age = CASE WHEN :#{#user.age} is null then u.age else :#{#user.age} end , " +
            "u.sex = CASE WHEN :#{#user.sex} is null then u.sex else :#{#user.sex} end , " +
            "u.createtime = CASE WHEN :#{#user.createtime} is null then u.createtime else :#{#user.createtime} end  " +
            "where u.id = :#{#user.id}")
    public void update(@Param("user") User user);
}
