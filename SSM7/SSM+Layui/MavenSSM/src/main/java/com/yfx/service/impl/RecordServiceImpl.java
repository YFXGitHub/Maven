package com.yfx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfx.dao.RecordMapper;
import com.yfx.entity.Record;
import com.yfx.service.RecordService;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordMapper recordMapper;
	
	@Override
	public void add(Record record) {
		
		recordMapper.add(record);
	}

}
