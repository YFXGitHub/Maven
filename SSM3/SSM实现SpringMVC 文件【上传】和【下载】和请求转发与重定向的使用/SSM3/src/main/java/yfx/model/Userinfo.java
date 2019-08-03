package yfx.model;

public class Userinfo {

	private String uname;
	private String upwd;
	private String uphone;
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
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	@Override
	public String toString() {
		return "Userinfo [uname=" + uname + ", upwd=" + upwd + ", uphone=" + uphone + "]";
	}
}
