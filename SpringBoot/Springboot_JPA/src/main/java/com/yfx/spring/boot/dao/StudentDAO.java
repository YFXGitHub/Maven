package com.yfx.spring.boot.dao;

import com.yfx.spring.boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository 完成对数据库的操作
public interface StudentDAO extends JpaRepository<Student, Integer> {
}
