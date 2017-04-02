package com.yc.taokefu.entity;

public class Project {
	private Integer pro_id;
	private String pro_name;
	private String pro_duty;
	private String pro_start_time;
	private String pro_end_time;
	private String pro_pdesc;
	private String pro_link ;
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_duty() {
		return pro_duty;
	}
	public void setPro_duty(String pro_duty) {
		this.pro_duty = pro_duty;
	}
	public String getPro_start_time() {
		return pro_start_time;
	}
	public void setPro_start_time(String pro_start_time) {
		this.pro_start_time = pro_start_time;
	}
	public String getPro_end_time() {
		return pro_end_time;
	}
	public void setPro_end_time(String pro_end_time) {
		this.pro_end_time = pro_end_time;
	}
	public String getPro_pdesc() {
		return pro_pdesc;
	}
	public void setPro_pdesc(String pro_pdesc) {
		this.pro_pdesc = pro_pdesc;
	}
	public String getPro_link() {
		return pro_link;
	}
	public void setPro_link(String pro_link) {
		this.pro_link = pro_link;
	}
	@Override
	public String toString() {
		return "Project [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_duty=" + pro_duty + ", pro_start_time="
				+ pro_start_time + ", pro_end_time=" + pro_end_time + ", pro_pdesc=" + pro_pdesc + ", pro_link="
				+ pro_link + "]";
	}
	
	
	
}
