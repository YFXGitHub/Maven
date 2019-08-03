package yfx.model;

import java.util.HashSet;
import java.util.Set;

public class Cls {

	private String cname;
	private Set Cls = new HashSet<>(0);

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	

	@Override
	public String toString() {
		return "Cls [cname=" + cname + "]";
	}
	
}
