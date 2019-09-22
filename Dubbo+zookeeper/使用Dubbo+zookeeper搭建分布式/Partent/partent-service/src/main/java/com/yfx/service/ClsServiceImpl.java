package com.yfx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.yfx.dao.ClsMapper;
import com.yfx.model.Cls;

@Service
public class ClsServiceImpl implements ClsService {

	@Autowired
	private ClsMapper clsMapper;
	
	@Override
	public List<Cls> findAll() {

		return clsMapper.findAll();
	}

}
