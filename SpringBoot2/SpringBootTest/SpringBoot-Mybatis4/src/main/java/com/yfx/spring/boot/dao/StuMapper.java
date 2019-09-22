package com.yfx.spring.boot.dao;

import com.yfx.spring.boot.model.Stu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
    //查询所有信息
    public List<Stu> findAll();
}
