package com.yfx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfx.model.Userinfo;

public interface UserinfoService {

	//查询所有数据
		public List<Userinfo> findAll();
		
		//分页显示数据
		public List<Userinfo> findPage(@Param("page") int page, @Param("limit") int limit);
		
		//分页获取总条数
		public int findAllSize();
		
		//修改
		public void update(Userinfo userinfo);
		
		//删除
		public boolean delete(@Param("uid") int uid);
}
