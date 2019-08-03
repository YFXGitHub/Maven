package com.model;

import java.util.HashSet;
import java.util.Set;

public class Cls {
	private Integer cid;
	private String cname;
	private Set Stu = new HashSet<>(0);
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
	public Set getStu() {
		return Stu;
	}
	public void setStu(Set stu) {
		Stu = stu;
	}
	@Override
	public String toString() {
		return "Cls [cid=" + cid + ", cname=" + cname + ", Stu=" + Stu + "]";
	}
	
}
