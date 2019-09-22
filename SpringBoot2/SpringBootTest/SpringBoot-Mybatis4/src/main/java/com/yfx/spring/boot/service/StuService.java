package com.yfx.spring.boot.service;

import com.yfx.spring.boot.model.Stu;

import java.util.List;

public interface StuService {
    //查询所有信息
    public List<Stu> findAll();
}
