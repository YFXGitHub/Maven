package com.yfx.springboot.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private Integer id;
    private String lastName;
    private Integer gender;     //0 女  1男
    private Date birth;
    private String strbirth;
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

    public String getStrbirth() {
        return strbirth;
    }
    public void setStrbirth(String strbirth) {
        this.strbirth = strbirth;
        try {
            //此处通过String类型的strbirth接收到表单中的日期，将其转换为Date放入birth中！
            this.birth =new SimpleDateFormat("yyyy-MM-dd").parse(strbirth);
          //  System.out.println( new SimpleDateFormat("yyyy-MM-dd").parse(strbirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
