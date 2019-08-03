package com.model;

public class Userinfo {

	private int id;
	private String name;
	private String age;
	private String sex;
	
	
	public Userinfo() {
		super();
	}
	public Userinfo(int id, String name, String age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}
