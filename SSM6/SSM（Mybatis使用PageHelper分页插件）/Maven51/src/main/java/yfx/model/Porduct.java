package yfx.model;



public class Porduct {
	private Integer pid;
	private String pname;
	private Float pice;
	private String pdesc;
	private String pdate;

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPice() {
		return pice;
	}
	public void setPice(Float pice) {
		this.pice = pice;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	@Override
	public String toString() {
		return "Porduct [pid=" + pid + ", pname=" + pname + ", pice=" + pice + ", pdesc=" + pdesc + ", pdate=" + pdate
				+ "]";
	}
	

}
