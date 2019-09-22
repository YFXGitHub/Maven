package com.yfx.springboot.entity;

public class User {
    private Integer uid;
    private String uname;
    private String upwd;
    private String emial;
    private String phone;

    public User(Integer uid, String uname, String upwd, String emial, String phone) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.emial = emial;
        this.phone = phone;
    }

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getEmial() {
        return emial;
    }
    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", emial='" + emial + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
