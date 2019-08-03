package com.yfx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfx.mapper.UserinfoMapper;
import com.yfx.model.Userinfo;

@Service
public class UserinfoServiceImpl implements UserinfoService{

	@Autowired
	private UserinfoMapper userinfoMapper;
	
	//查询所有数据
	@Override
	public List<Userinfo> findAll() {

		return userinfoMapper.findAll();
	}

	//修改
	@Override
	public void update(Userinfo userinfo) {
		
		userinfoMapper.update(userinfo);
	}

	//删除
	@Override
	public boolean delete(int uid) {
		
		return userinfoMapper.delete(uid);
	}

	//分页显示数据
	@Override
	public List<Userinfo> findPage(int page, int limit) {
		// TODO Auto-generated method stub
		return userinfoMapper.findPage(page, limit);
	}

	//分页获取总条数
	@Override
	public int findAllSize() {

		return userinfoMapper.findAllSize();
	}

}
