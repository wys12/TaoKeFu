package com.yc.taokefu.entity;

public class CompanyTeam {
	private Integer ct_id;
	private String ct_name;
	private String ct_picPath;
	private String ct_job;
	private String ct_tdesc;
	public Integer getCt_id() {
		return ct_id;
	}
	public void setCt_id(Integer ct_id) {
		this.ct_id = ct_id;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	public String getCt_picPath() {
		return ct_picPath;
	}
	public void setCt_picPath(String ct_picPath) {
		this.ct_picPath = ct_picPath;
	}
	public String getCt_job() {
		return ct_job;
	}
	public void setCt_job(String ct_job) {
		this.ct_job = ct_job;
	}
	public String getCt_tdesc() {
		return ct_tdesc;
	}
	public void setCt_tdesc(String ct_tdesc) {
		this.ct_tdesc = ct_tdesc;
	}
	@Override
	public String toString() {
		return "CompanyTeam [ct_id=" + ct_id + ", ct_name=" + ct_name + ", ct_picPath=" + ct_picPath + ", ct_job="
				+ ct_job + ", ct_tdesc=" + ct_tdesc + "]";
	}
	
	
	
}
