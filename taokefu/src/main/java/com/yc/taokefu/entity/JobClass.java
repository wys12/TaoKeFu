package com.yc.taokefu.entity;

public class JobClass {
	private Integer jc_id;
	private String jc_name;
	private String jc_type;
	public Integer getJc_id() {
		return jc_id;
	}
	public void setJc_id(Integer jc_id) {
		this.jc_id = jc_id;
	}
	public String getJc_name() {
		return jc_name;
	}
	public void setJc_name(String jc_name) {
		this.jc_name = jc_name;
	}
	public String getJc_type() {
		return jc_type;
	}
	public void setJc_type(String jc_type) {
		this.jc_type = jc_type;
	}
	@Override
	public String toString() {
		return "JobClass [jc_id=" + jc_id + ", jc_name=" + jc_name + ", jc_type=" + jc_type + "]";
	}
}
