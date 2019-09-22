package com.yfx.spring.boot.dao;

import com.yfx.spring.boot.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherDAO extends JpaRepository<Publisher, Integer> {

  /*自定义sql查询语句
      @Query(value = "select * from publisher", nativeQuery=true)
      List<Publisher> getPubliserAll();
  */
}
