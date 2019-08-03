package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserinfoMapper;
import com.model.Userinfo;
import com.service.UserinfoService;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper userinfoMapper;
	
	//查询所有
	@Override
	public List<Userinfo> findAllUserinfo() {

		return userinfoMapper.findAllUserinfo();
	}

	@Override
	public Userinfo findUserinfoById(int uid) {

		return userinfoMapper.findUserinfoById(uid);
	}

	@Override
	public void update(Userinfo userinfo) {
		
		userinfoMapper.update(userinfo);
	}

	@Override
	public void delete(int uid) {
		
		userinfoMapper.delete(uid);
	}

}
