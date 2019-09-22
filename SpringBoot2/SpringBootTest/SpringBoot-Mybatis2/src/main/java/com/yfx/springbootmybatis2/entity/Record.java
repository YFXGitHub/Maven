package com.yfx.springbootmybatis2.entity;

import java.util.Date;

public class Record {

    private Integer id;
    private String person;
    private String function;
    private Date date;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }

    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", function='" + function + '\'' +
                ", date=" + date +
                '}';
    }
}
