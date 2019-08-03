package yfx.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String name;
	private String pwd;
	private Cls cls;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Cls getCls() {
		return cls;
	}
	public void setCls(Cls cls) {
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + ", cls=" + cls + "]";
	}
	
	
}
