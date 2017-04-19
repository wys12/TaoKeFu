package com.yc.taokefu.entity;

public class Job {
	private Integer job_id;
	private Integer c_id;
	private String job_tags;  //标签
	private String job_name;
	private String job_department; //职位部门 
	private String job_nature;   //职位性质
	private String job_min_salary;
	private String job_max_salary;
	private String job_ftime;
	private String job_education; //学历要求,
	private String job_tempt;	//职位诱惑
	private String job_responsibility; //工作职责
	private String job_need;		//任职要求
	private String  job_rests ;  //-其他
	private String job_number ;
	private String job_state;
	private String  job_start_time;
	private String job_end_time;
	private String job_city;
	private String job_address;
	private String job_classes;	
	private String job_experience;
	public String getJob_city() {
		return job_city;
	}
	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}
	public String getJob_address() {
		return job_address;
	}
	public void setJob_address(String job_address) {
		this.job_address = job_address;
	}
	public String getJob_classes() {
		return job_classes;
	}
	public void setJob_classes(String job_classes) {
		this.job_classes = job_classes;
	}
	public String getJob_experience() {
		return job_experience;
	}
	public void setJob_experience(String job_experience) {
		this.job_experience = job_experience;
	}
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getJob_tags() {
		return job_tags;
	}
	public void setJob_tags(String job_tags) {
		this.job_tags = job_tags;
	}
	public String getJob_name() {
		return job_name;
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
	public String getJob_education() {
		return job_education;
	}
	public void setJob_education(String job_education) {
		this.job_education = job_education;
	}
	public String getJob_tempt() {
		return job_tempt;
	}
	public void setJob_tempt(String job_tempt) {
		this.job_tempt = job_tempt;
	}
	public String getJob_responsibility() {
		return job_responsibility;
	}
	public void setJob_responsibility(String job_responsibility) {
		this.job_responsibility = job_responsibility;
	}
	public String getJob_need() {
		return job_need;
	}
	public void setJob_need(String job_need) {
		this.job_need = job_need;
	}
	public String getJob_rests() {
		return job_rests;
	}
	public void setJob_rests(String job_rests) {
		this.job_rests = job_rests;
	}
	public String getJob_number() {
		return job_number;
	}
	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}
	public String getJob_start_time() {
		return job_start_time;
	}
	public void setJob_start_time(String job_start_time) {
		this.job_start_time = job_start_time;
	}
	public String getJob_end_time() {
		return job_end_time;
	}
	public void setJob_end_time(String job_end_time) {
		this.job_end_time = job_end_time;
	}
	public String getJob_state() {
		return job_state;
	}
	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}
	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", c_id=" + c_id + ", job_tags=" + job_tags + ", job_name=" + job_name
				+ ", job_department=" + job_department + ", job_nature=" + job_nature + ", job_min_salary="
				+ job_min_salary + ", job_max_salary=" + job_max_salary + ", job_ftime=" + job_ftime
				+ ", job_education=" + job_education + ", job_tempt=" + job_tempt + ", job_responsibility="
				+ job_responsibility + ", job_need=" + job_need + ", job_rests=" + job_rests + ", job_number="
				+ job_number + ", job_state=" + job_state + ", job_start_time=" + job_start_time + ", job_end_time="
				+ job_end_time + ", job_city=" + job_city + ", job_address=" + job_address + ", job_classes="
				+ job_classes + ", job_experience=" + job_experience + "]";
	}
	
}
