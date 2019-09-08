package com.yfx.spring.boot.model;


import javax.persistence.*;

//一个实体类
@Entity
@Table(name = "tab_stu")    //决定此实体类与那个表对应、省略则默认！
public class Student {
    @Id                 //iD
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //表示这是一个能够自增的主键
    private Integer id;
    @Column(name = "name", length = 30)         //实体类中的属性与表字段不一致，设置长度
    private String stuname;
    @Column         //省略name名  就是默认
    private String sex;
    @Column
    private Integer age;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }
    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
