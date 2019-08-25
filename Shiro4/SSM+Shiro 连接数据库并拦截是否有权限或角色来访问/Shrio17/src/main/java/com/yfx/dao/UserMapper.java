package com.yfx.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.yfx.entity.User;

public interface UserMapper {
	
	//查询所有的用户信息
	public List<User> findAll();
	
	//根据用户名查询：当前用户的信息
	public User findByName(String name);
	
	//注册 添加用户信息
	public void save(User user);
	
	//# 查询用户下 有哪些角色
	public Set<String> findByUserRoles(@Param("name") String name);
	
	//# 查询用户下有 哪些权限 
	public Set<String> findByUserPermissions(@Param("name") String name);
	
}
