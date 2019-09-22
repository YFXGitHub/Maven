package com.yfx.spring.boot.model;

public class Stu {
    private Integer sid;
    private String name;
    private String age;
    private String sex;
    private Integer cid;
    private Cls cls;

    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Cls getCls() {
        return cls;
    }
    public void setCls(Cls cls) {
        this.cls = cls;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", cid=" + cid +
                ", cls=" + cls +
                '}';
    }
}
