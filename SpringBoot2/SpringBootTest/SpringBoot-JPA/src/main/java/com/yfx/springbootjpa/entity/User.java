package com.yfx.springbootjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_stu")            //设置实体类与之对应的表，这里就是指User  ->  tab_stu 表
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             //指名这是一个主键，具有自增
    private Integer id;
    @Column(name = "stuname")       //设置name值 就说明表字段与属性名不一致，需要指定
    private String name;
    @Column
    private String pwd;
    @Column
    private String sex;
    @Column
    private Integer age;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
