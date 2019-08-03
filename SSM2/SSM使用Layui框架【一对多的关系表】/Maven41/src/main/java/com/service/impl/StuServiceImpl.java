package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StuMapper;
import com.model.Stu;
import com.service.StuService;

@Service
public class StuServiceImpl implements StuService {

	@Autowired
	private StuMapper stuMapper;
	
	@Override
	public List<Stu> findAllStuPage(int page, int limit) {

		return stuMapper.findAllStuPage(page, limit);
	}

	@Override
	public int findStuSize() {

		return stuMapper.findStuSize();
	}

	@Override
	public void delete(int sid) {

		stuMapper.delete(sid);
	}
	
	//update
	@Override
	public void udpate(Stu stu) {
		
		stuMapper.udpate(stu);
	}

}
