package com.yc.taokefu.entity;

public class Educationa {

	private Integer edu_id;
	private Integer tkf_id;
	private String edu_shool_name;
	private String edu_major;
	private String edu_educationa;
	private String edu_graduation_year;
	public Educationa() {
	}
	public Educationa( Integer tkf_id, String edu_shool_name, String edu_major, String edu_educationa,
			String edu_graduation_year) {
		this.tkf_id = tkf_id;
		this.edu_shool_name = edu_shool_name;
		this.edu_major = edu_major;
		this.edu_educationa = edu_educationa;
		this.edu_graduation_year = edu_graduation_year;
	}

	public Integer getEdu_id() {
		return edu_id;
	}
	public void setEdu_id(Integer edu_id) {
		this.edu_id = edu_id;
	}
	public Integer getTkf_id() {
		return tkf_id;
	}
	public void setTkf_id(Integer tkf_id) {
		this.tkf_id = tkf_id;
	}
	public String getEdu_shool_name() {
		return edu_shool_name;
	}
	public void setEdu_shool_name(String edu_shool_name) {
		this.edu_shool_name = edu_shool_name;
	}
	public String getEdu_major() {
		return edu_major;
	}
	public void setEdu_major(String edu_major) {
		this.edu_major = edu_major;
	}
	public String getEdu_educationa() {
		return edu_educationa;
	}
	public void setEdu_educationa(String edu_educationa) {
		this.edu_educationa = edu_educationa;
	}
	public String getEdu_graduation_year() {
		return edu_graduation_year;
	}
	public void setEdu_graduation_year(String edu_graduation_year) {
		this.edu_graduation_year = edu_graduation_year;
	}
	@Override
	public String toString() {
		return "Educationa [edu_id=" + edu_id + ", tkf_id=" + tkf_id + ", edu_shool_name=" + edu_shool_name
				+ ", edu_major=" + edu_major + ", edu_educationa=" + edu_educationa + ", edu_graduation_year="
				+ edu_graduation_year + "]";
	}

	
}
