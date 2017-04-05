--删除
drop table admin
drop table login
drop table tkfuser--用户基本信息
	drop table educationa--教育信息
	drop table project--项目经验
	drop table hope_job	--工作期望
drop table company--公司基本信息
	drop table tag--公司标签
	drop table company_team--公司团队
	drop table product--公司产品（项目）
drop table job_class --职位类别
	drop table job--职位信息
	
--查询
select * from admin--管理员
select * from login
select * from tkfuser--用户
	select * from educationa--教育信息
	select * from project--项目经验
	select * from hope_job--工作期望
select * from company--公司
	select * from tag--公司标签
	select * from company_team--公司团队
	select * from product--公司产品（项目）
select * from job_class--职位分类
	select * from job--职位信息
	
select *
  from job j
  join company comp
    on j.c_id = comp.comp_id
  join product pr
    on pr.c_id = comp.comp_id
  join product pro
    on pro.c_id = pr.c_id
 where j.job_id = 1001
	
	
select * from educationa where tkf_id=1061
select * from job where job_name='前端开发'
--创建序列
--select sequence
create sequence admin_sql INCREMENT BY 1 START WITH 1001 ;--管理员序列序列
create sequence login_sql INCREMENT BY 1 START WITH 1001 ;--登录序列
create sequence tkfuser_sql INCREMENT BY 1 START WITH 1001 ;--个人信息序列
	create sequence edu_sql INCREMENT BY 1 START WITH 1001 ;--学历序列
	create sequence project_sql INCREMENT BY 1 START WITH 1001 ;--项目经验序列
	create sequence hope_job_sql INCREMENT BY 1 START WITH 1001 ;--期望序列
create sequence com_sql INCREMENT BY 1 START WITH 1001 ;--公司序列
	create sequence tag_sql INCREMENT BY 1 START WITH 1001 ;--公司标签序列
	create sequence company_team_sql INCREMENT BY 1 START WITH 1001 ;--公司团队序列
	create sequence product_sql INCREMENT BY 1 START WITH 1001 ;--公司产品序列
create sequence jobClass_sql INCREMENT BY 1 START WITH 1001 ;--职位类别序列
	create sequence job_sql INCREMENT BY 1 START WITH 1001 ;--职位序列



--select tkfuser_sql.nextval from dual;
--drop sequence jobcalss_sql--用户信息序列

---admin
create table admin(
  ad_id number primary key ,
  ad_name varchar2(10) not null,
  ad_pwd varchar2(10) not null
);
insert into admin values(1,'aaa','a')

select * from login;
insert into login values (login_sql.nextval,'123@qq.com','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','1');
update LOGIN set l_type=0 where l_id=1041

--insert into login values (login_sql.nextval,'123@qq.com','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','1');

create table login(
  l_id number primary key ,
  l_email varchar2(20) not null UNIQUE,
  l_pwd varchar2(100) not null,
  l_type varchar2(10) check (l_type in('0','1')) not null
);


--insert into tkfuser values (login_sql.nextval,'李四',null,'我是李四',default,'衡大','三年','12345678901','111111@qq.com');
--  个人信息user  --个人介绍
create table tkfuser(
  us_id number primary key,
  us_name varchar2(10) ,
  us_picpath varchar2(50),      --图片路径
  us_intro varchar2(100),       --简介
  us_sex  varchar2(3) ,         --性别
  us_educationa varchar2(10) ,  -- 学历
  us_work_year  varchar2(20) ,  --工作年限
  us_phone varchar2(11) ,       --联系方式
  us_email varchar2(50) not null UNIQUE   --邮箱 
);



--insert into educationa values(edu_sql.nextval,tkf_id,edu_shoolname,edu_major,edu_educationa,edu_graduation_year);
--教育经验表
create table educationa(
  edu_id number primary key,
  tkf_id number not null,
  edu_shool_name varchar2(20) not null,  --学校名称
  edu_major varchar2(10) not null, --所学专业
  edu_educationa varchar2(20) not null, --学历
  edu_graduation_year varchar2(20) not null, --毕业年份
  foreign key (tkf_id) references tkfuser(us_id)
);


--项目经验  project
create table project(
  pro_id  number primary key,
  tkf_id number not null,
  pro_name varchar2(20)not null,
  pro_duty varchar2(10)not null,  --职责 
  pro_start_time varchar2(10)not null,
  pro_end_time varchar2(10)not null,
  pro_pdesc varchar2(200)not null,  --项目描述
  pro_link varchar2(30)not null,   --项目链接 
  foreign key (tkf_id) references tkfuser(us_id)
);


--期望工作 hope_job
create table hope_job(
  hj_id  number primary key,
  tkf_id number not null,
  hj_name varchar2(10)not null,
  hj_city varchar2(10)not null,
  hj_salary varchar2(10)not null,
  hj_state varchar2(100),   --说明
  foreign key (tkf_id) references tkfuser(us_id)
);

insert into company (comp_id,comp_name,comp_email ) values(com_sql.nextval,'百度','666666.qq.com')
--公司 company
create table company(
  comp_id number primary key,
  comp_name varchar2(10),
  comp_logo varchar2(50),
  comp_intor varchar2(50), 
  comp_phone varchar2(20),
  comp_email varchar2(100) not null UNIQUE,
  comp_link varchar2(255), 
  comp_city varchar2(20)
);

 insert into tag values(tag_sql.nextval,1001,'网络')
 insert into tag values(tag_sql.nextval,1001,'客服')
 insert into tag values(tag_sql.nextval,1001,'计算机')
select * from tag
update tag set c_id=1002 where tag_id=1002
delete tag where tag_id=1003
--公司标签
 create table tag(
  tag_id number primary key,
  c_id number not null,
  tag_name varchar2(50),
  foreign key (c_id) references company(comp_id)
 );

 
 insert into COMPANY_team (ct_id,c_id,ct_name,ct_tdesc) values (company_team_sql.nextval,1001,'编程开发','计算机行业的领头羊')
--公司管理团队
--drop table company_team
create table company_team(
  ct_id number primary key,
  c_id number not null,
  ct_name varchar2(20) not  null,  --
  ct_picPath varchar2(50),
  ct_job varchar2(20),   
  ct_tdesc varchar2(100),  --描述
  foreign key (ct_id) references company(comp_id)
);

insert into product (pro_id,c_id,pro_name,pro_link) values (product_sql.nextval,1001,'百度搜索','https://www.baidu.com')
--产品product
create table product(
  pro_id number  primary key,
  c_id number not null,
  pro_name varchar2(10) not null,
  pro_link varchar2(50) not null,
  pro_picPath varchar2(50) ,
  pro_pdesc varchar2(100),
  foreign key (c_id) references company(comp_id)
);

select * from company where comp_id=1001

select * from job where c_id=1001
insert into job values(job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary,job_max_salary,job_request)
insert into job values(job_sql.nextval,1001,'编程','qq客服','网络客服','初级客服','3k','3.5k','2017-4-3','清华硕士')
insert into job values(job_sql.nextval,1001,'编程','微信客服','网络客服','初级客服','3k','5k','2017-4-3','本科')

update job set job_request='清华硕士' where job_id=1001
select * from COMPANY
--职位表
create table job(
  job_id number primary key,
  c_id number not null,
  job_tags varchar2(30)  not null,
  job_name varchar2(20) not null,
  job_department  varchar2(10) not null, --职位部门 
  job_nature varchar2(20) not null, --职位性质
  job_min_salary varchar2(10) not null,
  job_max_salary varchar2(10) not null,
  job_ftime varchar2(10) not null ,--发布时间
  job_request varchar2(50) not null,  --职位要求
   foreign key (c_id) references company(comp_id)
);
insert into JOB_CLASS values(jobClass_sql.nextval,'编程')
--职位分类表
select * from JOB_CLASS
create table job_class(
  jc_id number primary key ,
  jc_name varchar2(20) not null
);
