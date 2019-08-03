package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClsMapper;
import com.model.Cls;
import com.service.ClsService;

@Service
public class ClsServiceImpl implements ClsService {

	@Autowired
	private ClsMapper clsMapper;
	
	@Override
	public List<Cls> findAllCls() {

		return clsMapper.findAllCls();
	}

	@Override
	public Cls findClsByid(int cid) {

		return clsMapper.findClsByid(cid);
	}

	@Override
	public void update(Cls cls) {

		clsMapper.update(cls);
	}

	@Override
	public void delete(int cid) {

		clsMapper.delete(cid);
	}

}
