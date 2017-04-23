package com.yc.taokefu.entity;

public class Product {
	private Integer c_id;
	private Integer cor_id;
	private String pro_name;
	private String pro_link;
	private String pro_picPath;
	private String pro_pdesc;
	public Integer getC_id() {
		return c_id;
	}
	public Integer getCor_id() {
		return cor_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public String getPro_link() {
		return pro_link;
	}
	public String getPro_picPath() {
		return pro_picPath;
	}
	public String getPro_pdesc() {
		return pro_pdesc;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public void setCor_id(Integer cor_id) {
		this.cor_id = cor_id;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public void setPro_link(String pro_link) {
		this.pro_link = pro_link;
	}
	public void setPro_picPath(String pro_picPath) {
		this.pro_picPath = pro_picPath;
	}
	public void setPro_pdesc(String pro_pdesc) {
		this.pro_pdesc = pro_pdesc;
	}
	@Override
	public String toString() {
		return "Product [c_id=" + c_id + ", cor_id=" + cor_id + ", pro_name=" + pro_name + ", pro_link=" + pro_link
				+ ", pro_picPath=" + pro_picPath + ", pro_pdesc=" + pro_pdesc + "]";
	}
	
	
	
	
}
