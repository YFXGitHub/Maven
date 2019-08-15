package yfx.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Orderss {
	private Integer oid;
	private String oNum;
	private Date otime;
	private String otimeString;
	private Integer opeopleCount;
	private String oDesc;
	private Integer opayType;
	private Integer ostatus;
	private Porduct porduct;
	
	public String getOtimeString() {
		return otimeString;
	}
	public void setOtimeString(String otimeString) {
		this.otimeString = otimeString;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getoNum() {
		return oNum;
	}
	public void setoNum(String oNum) {
		this.oNum = oNum;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
		this.setOtimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(otime));
	}
	public Integer getOpeopleCount() {
		return opeopleCount;
	}
	public void setOpeopleCount(Integer opeopleCount) {
		this.opeopleCount = opeopleCount;
	}
	public String getoDesc() {
		return oDesc;
	}
	public void setoDesc(String oDesc) {
		this.oDesc = oDesc;
	}
	public Integer getOpayType() {
		return opayType;
	}
	public void setOpayType(Integer opayType) {
		this.opayType = opayType;
	}
	public Integer getOstatus() {
		return ostatus;
	}
	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}
	public Porduct getPorduct() {
		return porduct;
	}
	public void setPorduct(Porduct porduct) {
		this.porduct = porduct;
	}
	@Override
	public String toString() {
		return "Orderss [oid=" + oid + ", oNum=" + oNum + ", otime=" + otime + ", opeopleCount=" + opeopleCount
				+ ", oDesc=" + oDesc + ", opayType=" + opayType + ", ostatus=" + ostatus + ", porduct=" + porduct + "]";
	}
	
	
}
