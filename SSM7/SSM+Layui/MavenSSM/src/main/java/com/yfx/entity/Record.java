package com.yfx.entity;

import java.util.Date;
//记录表
public class Record {
	private Integer id;
	private String person;
	private String function;
	private Date date;
	
	
	public Record(String person, String function) {
		super();
		this.person = person;
		this.function = function;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	

}
