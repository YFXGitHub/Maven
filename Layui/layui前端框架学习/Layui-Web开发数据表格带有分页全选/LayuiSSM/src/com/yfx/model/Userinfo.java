package com.yfx.model;

//实体类
public class Userinfo {

	private int uid;
	private String uname;
	private char usex;
	private int uage;
	private String uaddress;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public char getUsex() {
		return usex;
	}
	public void setUsex(char usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", usex=" + usex + ", uage=" + uage + ", uaddress="
				+ uaddress + "]";
	}
	
}
