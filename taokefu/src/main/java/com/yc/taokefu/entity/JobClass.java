package com.yc.taokefu.entity;

public class JobClass {
	private Integer jc_id;
	private String jc_name;
	private String jc_type;
	private String value_key;
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
	 
	public String getValue_key() {
		return value_key;
	}
	public void setValue_key(String value_key) {
		this.value_key = value_key;
	}
	@Override
	public String toString() {
		return "JobClass [jc_id=" + jc_id + ", jc_name=" + jc_name + ", jc_type=" + jc_type + ", value_key=" + value_key
				+ "]";
	}
	
}
