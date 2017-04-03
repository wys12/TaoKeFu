package com.yc.taokefu.entity;

public class Job {
	private Integer job_id;
	private Integer c_id;
	private String job_name;
	private String job_department; //职位部门 
	private String job_nature;   //职位性质
	private String job_min_salary;
	private String job_max_salary;
	private String job_ftime;
	private String job_request;
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_department() {
		return job_department;
	}
	public void setJob_department(String job_department) {
		this.job_department = job_department;
	}
	public String getJob_nature() {
		return job_nature;
	}
	public void setJob_nature(String job_nature) {
		this.job_nature = job_nature;
	}
	public String getJob_min_salary() {
		return job_min_salary;
	}
	public void setJob_min_salary(String job_min_salary) {
		this.job_min_salary = job_min_salary;
	}
	public String getJob_max_salary() {
		return job_max_salary;
	}
	public void setJob_max_salary(String job_max_salary) {
		this.job_max_salary = job_max_salary;
	}
	public String getJob_ftime() {
		return job_ftime;
	}
	public void setJob_ftime(String job_ftime) {
		this.job_ftime = job_ftime;
	}
	public String getJob_request() {
		return job_request;
	}
	public void setJob_request(String job_request) {
		this.job_request = job_request;
	}
	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", c_id=" + c_id + ", job_name=" + job_name + ", job_department="
				+ job_department + ", job_nature=" + job_nature + ", job_min_salary=" + job_min_salary
				+ ", job_max_salary=" + job_max_salary + ", job_ftime=" + job_ftime + ", job_request=" + job_request
				+ "]";
	}
	
	
	
}
