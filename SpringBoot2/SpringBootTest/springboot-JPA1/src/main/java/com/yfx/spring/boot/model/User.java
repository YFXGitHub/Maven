package com.yfx.spring.boot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tab_User")       //name属性表示 表名与实体类不一致，需要配置指定！
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //这表示自增
    private Integer id;
    @Column(name = "username", length = 30, unique = true)         //出现name属性表示 表中的字段属性与实体类的属性不一致，这时需要配置！
    private String name;
    @Column(length = 30)
    private String pwd;
    @Column
    private Integer age;
    @Column
    private String sex;
    @Column
    private Date createtime;

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

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
