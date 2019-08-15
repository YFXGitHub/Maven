package com.yfx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfx.dao.UserinfoMapper;
import com.yfx.entity.Userinfo;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper userinfoMapper;
	
	//<!-- 查询所有数据 -->
	@Override
	public List<Userinfo> findAll() {

		return userinfoMapper.findAll();
	}

}
