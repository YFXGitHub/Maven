package com.yfx.spring.boot.model;

import java.util.Set;

public class Cls {
    private  Integer cid;
    private String cname;
    private Set<Stu> stu;

    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Stu> getStu() {
        return stu;
    }
    public void setStu(Set<Stu> stu) {
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "Cls{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stu=" + stu +
                '}';
    }
}
