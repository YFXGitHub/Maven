package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Cls;

public interface ClsService {

	public List<Cls> findAllCls();
	
	public Cls findClsByid(@Param("cid") int cid);
	
	public void update(Cls cls);
	
	public void delete(@Param("cid") int cid);
}
