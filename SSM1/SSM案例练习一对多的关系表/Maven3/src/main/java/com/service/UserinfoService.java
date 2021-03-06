package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Userinfo;

public interface UserinfoService {

	public List<Userinfo> findAllUserinfo(); 
	
	public Userinfo findUserinfoById(@Param("uid") int uid);
	
	public void update(Userinfo userinfo);
	
	public void delete(@Param("uid") int uid);
}
