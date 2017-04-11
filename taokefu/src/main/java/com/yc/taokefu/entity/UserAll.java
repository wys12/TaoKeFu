package com.yc.taokefu.entity;

public class UserAll {
	/*----------------个人基础信息---------------------*/
	private Integer us_id;
	private String us_name;
	private String us_picpath;//图片路径
	private String us_intro;//简介
	private String us_sex;
	private String us_educationa;//学历
	private String us_work_year;//工作年限
	private String us_phone;//联系方式
	private String us_email;//邮箱
	private String openId;//邮箱
	/*----------------个人简历表---------------------*/
	private Integer tkf_id;
	private Integer c_id;
	private Integer usr_id;
	private String usr_name;//简历名称
	private String usr_state;//简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
	private String hj_name;//职位名称
	private String hj_city;//工作地址
	private String hj_min_salary;//期望月薪 
	private String hj_max_salary;//期望月薪 
	private String hj_nature;//职位性质（全职/兼职/实习）
	private String des_content;//描述内容

	/*---------------作品展示----------------------*/
	private Integer suc_id;
	private String suc_name;//作品名称
	private String suc_link;//作品链接

	/*--------------工作经历-----------------------*/
	private Integer exp_id;
	private String exp_company_name;//工作公司
	private String exp_job_name;//工作职位
	private String exp_start_year;//起始时间
	private String exp_end_year;//结束时间
	private String exp_work;
	private String  exp_city;

	public String getExp_work() {
		return exp_work;
	}
	public String getExp_city() {
		return exp_city;
	}
	public void setExp_city(String exp_city) {
		this.exp_city = exp_city;
	}
	public void setExp_work(String exp_work) {
		this.exp_work = exp_work;
	}
	/*---------------个人学历----------------------*/
	private Integer edu_id;
	private String edu_shool_name;//
	private String edu_major;//所学专业
	private String edu_educationa;//学历
	private String edu_start_year;//开始年份
	private String edu_end_year;//毕业年份

	/*---------------收藏职位----------------------*/
	private Integer col_id;
	private Integer col_job_id;//收藏职位id
	
	/*---------------订阅职位----------------------*/
	private Integer tak_id;
	private Integer tak_job_id;	//订阅职位id
	private String tak_email;
	private String tak_time;//接收时间
	private String tak_job_name;//职位名称
	private String tak_job_city;//工作城市
	private String tak_state;//发展状态
	private String tak_territory;//行业领域
	private String tak_min_salary;//工资
	private String tak_max_salary;//工资
	public Integer getUs_id() {
		return us_id;
	}
	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}
	public String getUs_name() {
		return us_name;
	}
	public void setUs_name(String us_name) {
		this.us_name = us_name;
	}
	public String getUs_picpath() {
		return us_picpath;
	}
	public void setUs_picpath(String us_picpath) {
		this.us_picpath = us_picpath;
	}
	public String getUs_intro() {
		return us_intro;
	}
	public void setUs_intro(String us_intro) {
		this.us_intro = us_intro;
	}
	public String getUs_sex() {
		return us_sex;
	}
	public void setUs_sex(String us_sex) {
		this.us_sex = us_sex;
	}
	public String getUs_educationa() {
		return us_educationa;
	}
	public void setUs_educationa(String us_educationa) {
		this.us_educationa = us_educationa;
	}
	public String getUs_work_year() {
		return us_work_year;
	}
	public void setUs_work_year(String us_work_year) {
		this.us_work_year = us_work_year;
	}
	public String getUs_phone() {
		return us_phone;
	}
	public void setUs_phone(String us_phone) {
		this.us_phone = us_phone;
	}
	public String getUs_email() {
		return us_email;
	}
	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}
	
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getTkf_id() {
		return tkf_id;
	}
	public void setTkf_id(Integer tkf_id) {
		this.tkf_id = tkf_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_state() {
		return usr_state;
	}
	public void setUsr_state(String usr_state) {
		this.usr_state = usr_state;
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
	public String getHj_min_salary() {
		return hj_min_salary;
	}
	public void setHj_min_salary(String hj_min_salary) {
		this.hj_min_salary = hj_min_salary;
	}
	public String getHj_max_salary() {
		return hj_max_salary;
	}
	public void setHj_max_salary(String hj_max_salary) {
		this.hj_max_salary = hj_max_salary;
	}
	public String getHj_nature() {
		return hj_nature;
	}
	public void setHj_nature(String hj_nature) {
		this.hj_nature = hj_nature;
	}
	public String getDes_content() {
		return des_content;
	}
	public void setDes_content(String des_content) {
		this.des_content = des_content;
	}
	public Integer getSuc_id() {
		return suc_id;
	}
	public void setSuc_id(Integer suc_id) {
		this.suc_id = suc_id;
	}
	public String getSuc_name() {
		return suc_name;
	}
	public void setSuc_name(String suc_name) {
		this.suc_name = suc_name;
	}
	public String getSuc_link() {
		return suc_link;
	}
	public void setSuc_link(String suc_link) {
		this.suc_link = suc_link;
	}
	public Integer getExp_id() {
		return exp_id;
	}
	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}
	public String getExp_company_name() {
		return exp_company_name;
	}
	public void setExp_company_name(String exp_company_name) {
		this.exp_company_name = exp_company_name;
	}
	public String getExp_job_name() {
		return exp_job_name;
	}
	public void setExp_job_name(String exp_job_name) {
		this.exp_job_name = exp_job_name;
	}
	public String getExp_start_year() {
		return exp_start_year;
	}
	public void setExp_start_year(String exp_start_year) {
		this.exp_start_year = exp_start_year;
	}
	public String getExp_end_year() {
		return exp_end_year;
	}
	public void setExp_end_year(String exp_end_year) {
		this.exp_end_year = exp_end_year;
	}
	public Integer getEdu_id() {
		return edu_id;
	}
	public void setEdu_id(Integer edu_id) {
		this.edu_id = edu_id;
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
	public String getEdu_start_year() {
		return edu_start_year;
	}
	public void setEdu_start_year(String edu_start_year) {
		this.edu_start_year = edu_start_year;
	}
	public String getEdu_end_year() {
		return edu_end_year;
	}
	public void setEdu_end_year(String edu_end_year) {
		this.edu_end_year = edu_end_year;
	}
	public Integer getCol_id() {
		return col_id;
	}
	public void setCol_id(Integer col_id) {
		this.col_id = col_id;
	}
	public Integer getCol_job_id() {
		return col_job_id;
	}
	public void setCol_job_id(Integer col_job_id) {
		this.col_job_id = col_job_id;
	}
	public Integer getTak_id() {
		return tak_id;
	}
	public void setTak_id(Integer tak_id) {
		this.tak_id = tak_id;
	}
	public Integer getTak_job_id() {
		return tak_job_id;
	}
	public void setTak_job_id(Integer tak_job_id) {
		this.tak_job_id = tak_job_id;
	}
	public String getTak_email() {
		return tak_email;
	}
	public void setTak_email(String tak_email) {
		this.tak_email = tak_email;
	}
	public String getTak_time() {
		return tak_time;
	}
	public void setTak_time(String tak_time) {
		this.tak_time = tak_time;
	}
	public String getTak_job_name() {
		return tak_job_name;
	}
	public void setTak_job_name(String tak_job_name) {
		this.tak_job_name = tak_job_name;
	}
	public String getTak_job_city() {
		return tak_job_city;
	}
	public void setTak_job_city(String tak_job_city) {
		this.tak_job_city = tak_job_city;
	}
	public String getTak_state() {
		return tak_state;
	}
	public void setTak_state(String tak_state) {
		this.tak_state = tak_state;
	}
	public String getTak_territory() {
		return tak_territory;
	}
	public void setTak_territory(String tak_territory) {
		this.tak_territory = tak_territory;
	}
	public String getTak_min_salary() {
		return tak_min_salary;
	}
	public void setTak_min_salary(String tak_min_salary) {
		this.tak_min_salary = tak_min_salary;
	}
	public String getTak_max_salary() {
		return tak_max_salary;
	}
	public void setTak_max_salary(String tak_max_salary) {
		this.tak_max_salary = tak_max_salary;
	}
	@Override
	public String toString() {
		return "UserAll [us_id=" + us_id + ", us_name=" + us_name + ", us_picpath=" + us_picpath + ", us_intro="
				+ us_intro + ", us_sex=" + us_sex + ", us_educationa=" + us_educationa + ", us_work_year="
				+ us_work_year + ", us_phone=" + us_phone + ", us_email=" + us_email + ", openId=" + openId
				+ ", tkf_id=" + tkf_id + ", c_id=" + c_id + ", usr_id=" + usr_id + ", usr_name=" + usr_name
				+ ", usr_state=" + usr_state + ", hj_name=" + hj_name + ", hj_city=" + hj_city + ", hj_min_salary="
				+ hj_min_salary + ", hj_max_salary=" + hj_max_salary + ", hj_nature=" + hj_nature + ", des_content="
				+ des_content + ", suc_id=" + suc_id + ", suc_name=" + suc_name + ", suc_link=" + suc_link + ", exp_id="
				+ exp_id + ", exp_company_name=" + exp_company_name + ", exp_job_name=" + exp_job_name
				+ ", exp_start_year=" + exp_start_year + ", exp_end_year=" + exp_end_year + ", exp_work=" + exp_work
				+ ", exp_city=" + exp_city + ", edu_id=" + edu_id + ", edu_shool_name=" + edu_shool_name
				+ ", edu_major=" + edu_major + ", edu_educationa=" + edu_educationa + ", edu_start_year="
				+ edu_start_year + ", edu_end_year=" + edu_end_year + ", col_id=" + col_id + ", col_job_id="
				+ col_job_id + ", tak_id=" + tak_id + ", tak_job_id=" + tak_job_id + ", tak_email=" + tak_email
				+ ", tak_time=" + tak_time + ", tak_job_name=" + tak_job_name + ", tak_job_city=" + tak_job_city
				+ ", tak_state=" + tak_state + ", tak_territory=" + tak_territory + ", tak_min_salary=" + tak_min_salary
				+ ", tak_max_salary=" + tak_max_salary + "]";
	}
	
	
	
}
