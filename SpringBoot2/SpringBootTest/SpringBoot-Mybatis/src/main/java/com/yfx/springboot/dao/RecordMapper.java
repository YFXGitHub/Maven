package com.yfx.springboot.dao;

import com.yfx.springboot.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface RecordMapper {

    Record getByid(@Param("id") Integer id);
}
