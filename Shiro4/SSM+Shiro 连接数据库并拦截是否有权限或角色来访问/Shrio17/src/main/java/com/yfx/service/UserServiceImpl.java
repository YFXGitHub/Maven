package com.yfx.service;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfx.dao.UserMapper;
import com.yfx.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	//根据用户名查询：获取密码
	@Override
	public String getPassword(String name) {
		User user = userMapper.findByName(name);
		if(user == null) {
			return null;
		}
		return user.getPassword();
	}

	//根据用户名查询：当前用户的 盐值
	@Override
	public String getSalt(String name) {
		User user = userMapper.findByName(name);
		if(user == null) {
			return null;
		}
		return user.getSalt();
	}

	//注册 添加用户信息
	@Override
	public void save(User user) {

		userMapper.save(user);
	}

	//# 查询用户下 有哪些角色
	@Override
	public Set<String> findByUserRoles(String name) {

		return userMapper.findByUserRoles(name);
	}

	//# 查询用户下有 哪些权限 
	@Override
	public Set<String> findByUserPermissions(String name) {

		return userMapper.findByUserPermissions(name);
	}

	//查询所有的用户信息
	@Override
	public List<User> findAll() {
		List<User> findAll = userMapper.findAll();
		if(findAll == null) {
			return null;
		}
		return findAll;
	}
	
	
	
}
