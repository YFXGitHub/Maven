package yfx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yfx.model.Orderss;

public interface OrderssMapper {

	//selectAll
	public List<Orderss> findAll();
	
	//findByid
	public Orderss findByid(@Param("oid") int oid);
	
	//delete
	public void delete(@Param("oid") int oid);
	
	//update
	public void update(Orderss orderss);
}
