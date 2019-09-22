package com.yfx.spring.boot.service;

import com.yfx.spring.boot.dao.StuMapper;
import com.yfx.spring.boot.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Stu> findAll() {
        return stuMapper.findAll();
    }
}
