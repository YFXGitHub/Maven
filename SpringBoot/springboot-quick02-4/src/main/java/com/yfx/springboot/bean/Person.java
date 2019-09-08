package com.yfx.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
    将配置文件中的属性值， 映射到这个实体类中！
    只有这个组件是容器组件，才能使用容器组件的功能。
    prefix = "键"
 */
//@PropertySource(value = "classpath:person.properties")  //此注解： 指定配置文件*.properties
@Component
@ConfigurationProperties( prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean sex;        //false 1, true 0
    private Date date;

    private Map<String, Object> map;
    private List<String> list;
    private Dog dog;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> getMap() {
        return map;
    }
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", date=" + date +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
