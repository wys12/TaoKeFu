package com.yc.taokefu.entity;

public class HopeJob {
	private Integer hj_id;
	private String hj_name;
	private String hj_city;
	private String hj_salary;
	private String hj_state;
	public Integer getHj_id() {
		return hj_id;
	}
	public void setHj_id(Integer hj_id) {
		this.hj_id = hj_id;
	}
	public String getHj_name() {
		return hj_name;
	}
	public void setHj_name(String hj_name) {
		this.hj_name = hj_name;
	}
	public String getHj_city() {
		return hj_city;
	}
	public void setHj_city(String hj_city) {
		this.hj_city = hj_city;
	}
	public String getHj_salary() {
		return hj_salary;
	}
	public void setHj_salary(String hj_salary) {
		this.hj_salary = hj_salary;
	}
	public String getHj_state() {
		return hj_state;
	}
	public void setHj_state(String hj_state) {
		this.hj_state = hj_state;
	}
	@Override
	public String toString() {
		return "HopeJob [hj_id=" + hj_id + ", hj_name=" + hj_name + ", hj_city=" + hj_city + ", hj_salary=" + hj_salary
				+ ", hj_state=" + hj_state + "]";
	}
	
	
}
