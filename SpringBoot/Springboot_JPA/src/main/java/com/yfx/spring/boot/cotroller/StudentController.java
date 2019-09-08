package com.yfx.spring.boot.cotroller;

import com.yfx.spring.boot.dao.StudentDAO;
import com.yfx.spring.boot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentDAO studentDAO;

    @GetMapping("/stu")
    public List<Student> toStus(){
        return studentDAO.findAll();
    }

    @GetMapping("/add")
    public Student toAdd(Student stu){

        return studentDAO.save(stu);
    }

}
