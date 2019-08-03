package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Stu;

public interface StuMapper {

	public List<Stu> findAllStu();
	
	public Stu findAllByid(@Param("sid") int sid);
	
	public void update(Stu stu);
	
	public void delete(@Param("sid") int sid);
}
