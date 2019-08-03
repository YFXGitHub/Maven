package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StuMapper;
import com.model.Stu;
import com.service.StuService;

@Service
public class StuServiceImpl implements StuService{

	@Autowired
	private StuMapper stuMapper;
	
	@Override
	public List<Stu> findAllStu() {

		return stuMapper.findAllStu();
	}

	@Override
	public Stu findAllByid(int sid) {

		return stuMapper.findAllByid(sid);
	}

	@Override
	public void update(Stu stu) {

		stuMapper.update(stu);
	}

	@Override
	public void delete(int sid) {

		stuMapper.delete(sid);
	}

}
