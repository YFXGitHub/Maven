package com.yfx.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.yfx.dao.TestDao;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestDao testDao;
	
	@Override
	public String getHello() {
		
		return "Hello!";
	}

}
