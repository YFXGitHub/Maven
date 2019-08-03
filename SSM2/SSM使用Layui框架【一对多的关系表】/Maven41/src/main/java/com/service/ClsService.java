package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Cls;

public interface ClsService {

	public List<Cls> findAllCls();
	
	//分页查询
	public List<Cls> findPageCls(@Param("page") int page, @Param("limit") int limit);
	
	// 分页 统计总条数
	public int findSize();
	
	//update
	public void update(Cls cls);
	
	//delete
	public void delete(@Param("cid") int cid);
}
