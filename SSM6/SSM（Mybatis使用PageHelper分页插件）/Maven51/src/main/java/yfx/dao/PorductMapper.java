package yfx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yfx.model.Porduct;

public interface PorductMapper {

	//查询所有数据 
	public List<Porduct> findPorductAll();
	
	//删除
	public void delete(@Param("pid") int pid);
	
	//根据id查询
	public Porduct findByid(@Param("pid") int pid);
	
	//update
	public void update(Porduct porduct);
	
	//add
	public void add(Porduct porduct);
}
