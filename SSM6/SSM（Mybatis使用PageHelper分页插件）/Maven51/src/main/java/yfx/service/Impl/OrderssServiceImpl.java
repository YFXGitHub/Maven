package yfx.service.Impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yfx.dao.OrderssMapper;
import yfx.model.Orderss;
import yfx.service.OrderssService;

@Service
public class OrderssServiceImpl implements OrderssService {

	@Autowired
	private OrderssMapper OrderssMapper;
	
	@Override
	public List<Orderss> findAll() {

		return OrderssMapper.findAll();
	}
	
	//delete
	@Override
	public void delete(int oid) {

		OrderssMapper.delete(oid);
	}

	//findByid
	@Override
	public Orderss findByid(int oid) {
		
		return OrderssMapper.findByid(oid);
	}

	//update
	@Override
	public void update(Orderss orderss) {
		
		OrderssMapper.update(orderss);
	}

}
