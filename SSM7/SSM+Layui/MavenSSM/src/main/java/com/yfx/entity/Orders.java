package com.yfx.entity;

import java.util.Date;

public class Orders {

	private Integer oid;
	private String oname;
	private String person;
	private String address;
	private String odesc ;
	private Date date;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOdesc() {
		return odesc;
	}
	public void setOdesc(String odesc) {
		this.odesc = odesc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", oname=" + oname + ", person=" + person + ", address=" + address + ", odesc="
				+ odesc + ", date=" + date + "]";
	}
	
}
