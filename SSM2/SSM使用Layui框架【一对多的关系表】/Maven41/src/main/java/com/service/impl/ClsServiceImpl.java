package com.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	//分页查询
	@Override
	public List<Cls> findPageCls(int page, int limit) {
		return clsMapper.findPageCls(page, limit);
	}

	// 分页 统计总条数
	@Override
	public int findSize() {
		return clsMapper.findSize();
	}

	//update
	@Override
	public void update(Cls cls) {

		clsMapper.update(cls);
	}

	//delete
	@Override
	public void delete(int cid) {

		clsMapper.delete(cid);
	}

}
