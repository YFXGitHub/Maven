package com.yfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfx.dao.OrdersMapper;
import com.yfx.entity.Orders;
import com.yfx.service.OrdersService;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public List<Orders> findPage(int page, int limit) {

		return ordersMapper.findPage(page, limit);
	}

	@Override
	public int countSize() {

		return ordersMapper.countSize();
	}

	@Override
	public void update(Orders orders) {

		ordersMapper.update(orders);
	}

	@Override
	public void add(Orders order) {

		ordersMapper.add(order);
	}

	@Override
	public void delete(int oid) {

		ordersMapper.delete(oid);
	}

	@Override
	public List<Orders> like(String oname) {

		return ordersMapper.like(oname);
	}

}
