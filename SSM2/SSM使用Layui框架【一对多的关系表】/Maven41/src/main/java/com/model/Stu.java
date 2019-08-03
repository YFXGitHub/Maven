package com.model;

public class Stu {
	private Integer sid;
	private String sname;
	private String sex;
	private Integer age;
	private Integer cj;
	private Cls cls;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public Integer getCj() {
		return cj;
	}
	public void setCj(Integer cj) {
		this.cj = cj;
	}
	public Cls getCls() {
		return cls;
	}
	public void setCls(Cls cls) {
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "Stu [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", age=" + age + ", cj=" + cj + ", cls=" + cls
				+ "]";
	}
}
