package com.yfx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yfx.entity.Orders;

public interface OrdersService {

	public List<Orders> findPage(@Param("page") int page, @Param("limit") int limit);
	
	public int countSize();
	
	public void update(Orders orders);
	
	public void add(Orders order);
	
	public void delete(@Param("oid") int oid);
	
	public List<Orders> like(String oname);
}
