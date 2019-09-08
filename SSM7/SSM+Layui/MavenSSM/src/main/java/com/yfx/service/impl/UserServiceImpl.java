package com.yfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfx.dao.UserMapper;
import com.yfx.entity.User;
import com.yfx.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {

		return userMapper.findAll();
	}

	@Override
	public User findByname(String uname) {

		return userMapper.findByname(uname);
	}

	@Override
	public int countSize() {
		
		return userMapper.countSize();
	}

	@Override
	public List<User> findPage(int page, int limit) {

		return userMapper.findPage(page, limit);
	}

	@Override
	public void delete(int uid) {

		userMapper.delete(uid);
	}

	@Override
	public void update(User user) {

		userMapper.update(user);
	}

	@Override
	public void reg(User user) {

		userMapper.reg(user);
	}

	@Override
	public User findById(int uid) {

		return userMapper.findById(uid);
	}

}
