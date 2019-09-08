package com.yfx.springboot.test;

import java.util.Date;

public class Employee {
    private Integer id;
    private String lastName;
    private Integer gender;     //0 女  1男
    private Date birth;
    private Department department;

    public Employee() {

    }
    public Employee(Integer id, String lastName, Integer gender, Date birth, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.birth = birth;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Emyloyee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", department=" + department +
                '}';
    }
}
