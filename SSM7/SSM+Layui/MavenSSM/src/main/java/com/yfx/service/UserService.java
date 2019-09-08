package com.yfx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfx.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findByname(String uname);
	
	public User findById(int uid);
	
	public int countSize();
	
	public List<User> findPage(@Param("page") int page, @Param("limit") int limit);
	
	public void delete(@Param("uid") int uid);
	
	public void update(User user);
	
	public void reg(User user);

}
