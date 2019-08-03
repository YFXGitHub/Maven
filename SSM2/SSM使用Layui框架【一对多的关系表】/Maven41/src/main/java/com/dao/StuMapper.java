package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Stu;

public interface StuMapper {

	//分页
	public List<Stu> findAllStuPage(@Param("page") int page, @Param("limit") int limit);
	
	//查询总条数
	public int findStuSize();
	
	//delete
	public void delete(@Param("sid") int sid);
	
	//update
	public void udpate(Stu stu);
}
