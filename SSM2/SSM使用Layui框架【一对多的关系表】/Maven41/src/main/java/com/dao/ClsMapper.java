package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Cls;

public interface ClsMapper {

	public List<Cls> findAllCls();
	
	public List<Cls> findPageCls(@Param("page") int page, @Param("limit") int limit);
	
	public int findSize();
	
	public void update(Cls cls);
	
	public void delete(@Param("cid") int cid);
}
