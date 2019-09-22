package com.yfx.model;

import java.io.Serializable;

public class Cls implements Serializable{

	private Integer cid;
	private String cname;
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
	@Override
	public String toString() {
		return "Cls [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
