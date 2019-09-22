package com.yfx.springbootmybatis2.dao;

import com.yfx.springbootmybatis2.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecordMapper {

    Record findById(@Param("id") Integer id);

}
