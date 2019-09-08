package com.yfx.springboot.test;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        System.out.println("main..........");

//        System.out.println( DepartmentDao.getDepartments());
//        System.out.println(DepartmentDao.getDepartment(102));
//
//        System.out.println(EmployeeDao.getAll());
    }
}

class Department{
    private Integer id;
    private String departmentName;

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}

