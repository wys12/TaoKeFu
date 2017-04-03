package com.yc.taokefu.entity;

public class Product {
	private Integer c_id;
	private Integer pro_id;
	private String pro_name;
	private String pro_link;
	private String pro_picPath;
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_link() {
		return pro_link;
	}
	public void setPro_link(String pro_link) {
		this.pro_link = pro_link;
	}
	public String getPro_picPath() {
		return pro_picPath;
	}
	public void setPro_picPath(String pro_picPath) {
		this.pro_picPath = pro_picPath;
	}
	@Override
	public String toString() {
		return "Product [c_id=" + c_id + ", pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_link=" + pro_link
				+ ", pro_picPath=" + pro_picPath + "]";
	}
	
	
	
}
