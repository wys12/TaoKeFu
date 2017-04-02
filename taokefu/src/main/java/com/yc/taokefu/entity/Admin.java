package com.yc.taokefu.entity;

public class Admin {
	private Integer ad_id;
	private String ad_name;
	private String ad_pwd;
	public Integer getAd_id() {
		return ad_id;
	}
	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_pwd() {
		return ad_pwd;
	}
	public void setAd_pwd(String ad_pwd) {
		this.ad_pwd = ad_pwd;
	}
	@Override
	public String toString() {
		return "Admin [ad_id=" + ad_id + ", ad_name=" + ad_name + ", ad_pwd=" + ad_pwd + "]";
	}

	
}
