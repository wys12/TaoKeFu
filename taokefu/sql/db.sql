insert into admin values('595068001@qq.com','admin','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2');
select * from admin;

---admin管理员
insert into ADMIN values(admin_sql.nextval,'admin','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','595068001@qq.com')
alert table admin add (ad_email varchar2(50));
drop table  admin;
select * from admin
create table admin(
  ad_id number primary key ,
  ad_name varchar2(20) not null,
  ad_pwd varchar2(50) not null,
  ad_email varchar2(30)
);
select * from LOGIN
--login	登录
create table login(
  l_id number primary key ,
  l_email varchar2(50) not null UNIQUE,
  l_pwd varchar2(100) not null,
  l_type varchar2(10) not null check (l_type in('0','1')) 
);


--insert into tkfuser values (login_sql.nextval,'李四',null,'我是李四',default,'衡大','三年','12345678901','111111@qq.com');
--user  个人信息  
update set tkfuser us_name=${us_name},us_picpath=${us_picpath},us_intro=${us_intro},
		us_sex=${us_sex},us_educationa=${us_educationa},us_work_year=${us_work_year},us_phone=${us_phone}
		 where us_id=${us_id} or openId=${openId} or us_email=${us_email}
		 
insert into tkfuser us_name=${us_name},us_picpath=${us_picpath},us_picpath=${us_picpath},us_intro=${us_intro},
us_sex=${us_sex},us_educationa=${us_educationa},us_work_year=${us_work_year},us_phone=${us_phone} 
where us_id=${us_id} or us_email=${us_email} or openId=${openId}  
select * from tkfuser
update tkfuser set us_intro='我的简介', us_sex='男',us_educationa='本科',us_work_year='5年',us_phone='13974412345' where us_id=1002
create table tkfuser(
  us_id number primary key,	--id等于 login id
  us_name varchar2(30) ,	--名称
  us_picpath varchar2(100),      --图片路径
  us_intro varchar2(200),       --简介
  us_sex  varchar2(3) check (us_sex in('男','女')),         --性别
  us_educationa varchar2(30) ,  -- 学历
  us_work_year  varchar2(30) ,  --工作年限
  us_phone varchar2(30) ,       --联系方式
  us_email varchar2(50) UNIQUE ,  --邮箱 
  openId varchar2(100) UNIQUE
);
select company_sql.nextval from dual
update company SET comp_name='辣翻天', comp_fullname='辣翻天有限公司', comp_state='A轮', comp_link='www.baidu.com', comp_city='湖南衡阳', comp_scale='少于15人', comp_introduce='辣翻天，辣不死！' where comp_email='332211@qq.com'
update company SET comp_attestation='-2' where comp_id = '1027'
select * from job
select * from company where comp_id=1081
update company set  tag_name='五险一金' where comp_id=1081
alter table company modify (comp_logo varchar2(200))
alter table company add (tag_name varchar2(150))
insert into company values(company_sql.nextval,'百度','北京百度网讯科技有限公司'，'http://www.baidu.com/img/bd_logo1.png','互联网','上市','(+86 10) 5992 8888','comnect@baidu.com','www.baidu.com','北京','5000-10000','百度一下,你就知道了','百度,全球最大的中文搜索引擎、最大的中文网站。1999年底,身在美国硅谷的李彦宏看到了中国互联网及中文搜 索引擎服务的巨大发展潜力,抱着技术改变世界的梦想,他毅然辞掉硅谷的高薪工作,携搜索引擎专利技术,于 2000年1月1日在中关村创建了百度公司。','','股票期权,绩效奖金,五险一金');
--company 公司 
create table company(
  comp_id number primary key,
  comp_name varchar2(30),	--公司简称
  comp_fullname varchar2(50),	--公司 全称
  comp_logo varchar2(200),	--logo
  comp_territory varchar2(30), 	--领域 (行业领域)
  comp_state varchar2(20),	--发展阶段/状体(上市/a轮)
  comp_phone varchar2(30),	--联系方式
  comp_email varchar2(100) not null UNIQUE, --邮箱
  comp_link varchar2(255), 	--公司主页链接
  comp_city varchar2(50), --城市
  comp_scale varchar2(30), --公司规模
  comp_introduce varchar2(50),	--公司一句话介绍
  comp_introduces varchar2(500),	--公司详情介绍
  comp_attestation varchar2(10) check(comp_attestation in('-0','-1')),--公司认证状态
  tag_name varchar2(150)
);

insert into usResume(usr_id,tkf_id) values(usResume_sql.nextval,)
--drop table usResume
 --resume	用户简历表(详情)
 update tkfuser set us_name='张三' where us_id=1002
 select * from tkfuser
 insert into usResume values(usResume_sql.nextval,1002,'','张三的简历','-0','qq客服','北京','5k','8k','-0','能吃苦耐劳，不怕加班');
 select * from usResume
create table usResume(
	usr_id number primary key,
	tkf_id number constraint tkf_id references tkfuser(us_id),
	c_id number constraint fk_usR_id references company(comp_id),
	usr_name varchar2(30),	--简历名称
	usr_state varchar2(10) check(usr_state in('-0','-1','-2','-3','-4')),	--简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
 --hope_job	期望工作
	hj_name varchar2(50) ,	--职位名称
	hj_city varchar2(50) ,	--工作地址
	hj_min_salary varchar2(30),	--期望月薪 
	hj_max_salary varchar2(30),	--期望月薪 
  	hj_nature varchar2(30) check(hj_nature in('-0','-1','-2')), --职位性质（全职/兼职/实习）
  --description	自我描述
	des_content varchar2(300) --描述内容
);
select * from resume where c_id=1001
select * from resume where c_id=1001 and usr_id=1002 
select * from resume
drop  table resume
delete resume where c_id=1002
	create table resume(
		 res_id number primary key,
		  c_id number ,
		 job_id number ,
		 usr_id number ,
		 us_name varchar2(30) ,
		 usr_name varchar2(30) ,
		 us_picpath varchar2(50) ,--图片路径
		 us_intro varchar2(200), --简介
		 us_sex varchar2(30) check(us_sex in('男','女')),
		 us_educationa varchar2(30), --学历
		 us_work_year varchar2(30), --工作年限
		 us_phone varchar2(30), --联系方式
		 us_email varchar2(50), --邮箱
	/*--------------工作经历-----------------------*/
		 exp_company_name varchar2(50) ,--工作公司
		 exp_job_name varchar2(50),--工作职位
		 exp_start_year varchar2(30) ,--起始时间
		 exp_end_year varchar2(30) ,--结束时间
		 exp_work varchar2(50),
		 exp_city varchar2(50),
		 
		 hj_name varchar2(50) ,--职位名称
		 hj_city varchar2(50) ,--工作地址
		 hj_min_salary varchar2(30) ,--期望月薪 
		 hj_max_salary varchar2(30),--期望月薪 
		 hj_nature varchar2(30) ,--职位性质（全职/兼职/实习）
		 des_content varchar2(200) ,--描述内容
		 
		 edu_shool_name varchar2(50),  --学校名称
		 edu_major varchar2(50), --所学专业
		 edu_educationa varchar2(30), --学历
		 edu_start_year varchar2(30),-- 开始年份
		 edu_end_year varchar2(30) ,--毕业年份
	
		 usr_state varchar2(30) check(usr_state in('-0','-1','-2','-3','-4','-5'))--简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
	);
insert into coResume values(comResume_sql.nextval,'1001','百度团队','团队图片','CEO','这是一个测试描述','百度搜索','www.baidu.com','产品图片','强大的搜索引擎','公司深度','深度链接');
 --resume	公司简历表(详情)
 select * from company
insert into coResume values(comResume_sql.nextval,'1053','百度糯米','www.nuomi.com','http://gss0.bdstatic.com/8r1VfDn9KggZnd_b8IqT0jB-xx1xbK/static/common/nis_index/sub/img/logo_e53daea.png'
,'还窝在家里，做别人眼中的宅男宅女吗？为什么不走出家门去攀岩、去K歌、去享受一顿丰盛的大餐？还在遗憾工作太忙，没时间和死党们欢聚吗？为什么不和闺蜜一起去做个SPA，或者干脆去拍套个性写真？还在纠结口袋里的银子，总觉得做个头发或美甲太贵吗？为什么不找个机会跟朋友们一起团购，杀出个痛快的价格出来？
我们提供的解决方案是：每天把最超值的团购消费带到您身边！
百度糯米，致力于通过团购的方式向消费者推荐高折扣的本地精品生活服务。');
--resume	公司简历表(详情)
 select * from coResume
 drop table coResume
create table coResume(
	cor_id number primary key,
	c_id number constraint fk_coR_id references company(comp_id),
 --product 产品
	pro_name varchar2(30),	--公司产品
	pro_link varchar2(50),	--产品链接
	pro_picPath varchar2(30),	--图片路径
	pro_pdesc varchar2(100), --产品描述
	pro_link varchar2(30),	--产品链接
	pro_picPath varchar2(300),	--图片路径
	pro_pdesc varchar2(500) --产品描述
 --deepness 公司深度
-- 	de_name varchar2(30),	--公司深度名称
-- 	dee_link varchar2(30)	--公司深度链接
);

drop table company_team
--company_team 公司管理团队
create table company_team(
	ct_id number primary key,
	c_id number constraint fk_ct_id references company(comp_id),
	ct_name varchar2(30),  --团队名称
	ct_picPath varchar2(50),	--图片路径
	ct_job varchar2(30),	--团队职位
	ct_tdesc varchar2(150)	--团队描述
	ct_name varchar2(20),  --团队名称
	ct_picPath varchar2(300),	--图片路径
	ct_job varchar2(20),	--团队职位
	ct_tdesc varchar2(300)	--团队描述
);
insert into experience values(experience_job_sql.nextval,1002,'阿里云','项目总监','5年','北京','2011.1','2016.1');
select * from educationa experience  usResume 
insert into company_team values(company_team_sql.nextval,'1053','百度糯米','http://gss0.bdstatic.com/8r1VfDn9KggZnd_b8IqT0jB-xx1xbK/static/common/nis_index/sub/img/logo_e53daea.png','客服工程师','百度糯米，致力于通过团购的方式向消费者推荐高折扣的本地精品生活服务。')
select * from company_team
	select * from job j join company comp on j.c_id = comp.comp_id join coResume cor on cor.c_id = comp.comp_id join tag t on cor.c_id=t.c_id join invest inv on inv.c_id = t.c_id where j.job_name like '%微信%' 
 --succeed	作品展示
create table succeed(
	suc_id number primary key,
	tkf_id number constraint fk_suc_id references usResume(usr_id),
	suc_name varchar2(20),	--作品名称
	suc_link varchar2(30)	--作品链接
);
 --experience	工作经历
create table experience(
	exp_id number  primary key,
	tkf_id number, --constraint fk_exp_id references usResume(usr_id),
	exp_company_name varchar2(30),	--工作公司
	exp_job_name varchar2(30),	--工作职位
	exp_work varchar2(20),--工作年纪
	exp_city varchar2(30),--city
	exp_start_year varchar2(20),	--起始时间
	exp_end_year varchar2(20)   --结束时间
);
insert into educationa values(educationa_sql.nextval,1002,'北大青鸟','java开发','专科','2008.9','2011.5');

 --educationa 个人学历
create table educationa(
	edu_id number primary key,
	tkf_id number,-- constraint fk_edu_id references usResume(usr_id),
	edu_shool_name varchar2(30),  --学校名称
	edu_major varchar2(30), --所学专业
	edu_educationa varchar2(20), --学历
	edu_start_year varchar2(20),-- 开始年份
	edu_end_year varchar2(20) --毕业年份
);

--收藏职位
create table collect(
	  col_id number primary key,
	  tkf_id number constraint fk_col_id references tkfuser(us_id),
	  col_job_id varchar2(10) 	--职位id
);

--订阅职位
create table take(
	  tak_id number primary key,
	  tkf_id number constraint fk_tak_id references tkfuser(us_id),
	  tak_job_id varchar2(10) ,	--职位id
	  tak_email varchar2(50) UNIQUE,   --邮箱 
	  tak_time varchar2(20),	--接收时间
	  tak_job_name varchar2(30), --职位名称
	  tak_job_city varchar2(30),	--工作城市
	  tak_state varchar2(50),	--发展状态
	  tak_territory varchar2(50),	--行业领域
	  tak_min_salary varchar2(20),	--工资
	  tak_max_salary varchar2(20)	--工资
);
select * from job j join company comp on j.c_id = comp.comp_id join coResume cor on cor.c_id = comp.comp_id where j.job_id=1001 
insert into tag values(tag_sql.nextval,'1001','五险一金');



insert into job 
values(job_sql.nextval,'1001','五险一金','qq客服','客服联系','全职','3k','5k','2017-04-05','本科','职位诱惑是休息时间多','qq客服工作的职责','qq客服任职的要求',
'qq客服其他的要求','0','-1');
insert into job 
values(job_sql.nextval,'1001','年终奖金翻倍','微信客服','客服联系','全职','4k','6k','2017-04-07','研究生','职位诱惑就是年底双薪','微信客服工作的职责','微信客服任职的要求',
'微信客服其他的要求','0','-0');
--职位表
select * from job
create table job(
  job_id number primary key,
  c_id number not null,
  job_tags varchar2(50) ,  --标签 （股票期权/五险一金）
  job_name varchar2(30) ,  --名称
  job_department  varchar2(30) , --职位部门 
  job_nature varchar2(20) , --职位性质（全职/兼职/实习）
  job_min_salary varchar2(10) ,  --最少工资
  job_max_salary varchar2(10),  --最多工资
  job_ftime varchar2(20)  ,--发布时间
  job_education varchar2(50) ,  --学历要求,
  job_tempt varchar2(100),  --职位诱惑
  job_responsibility varchar2(100) ,--工作职责
  job_need varchar2(100) ,--任职要求
  job_rests varchar2(100) ,--其他
  job_number varchar2(100), --点击量
  job_state varchar2(10) check(job_state in('-0','-1')), --职位状态   （在线职位/下线职位）
   foreign key (c_id) references company(comp_id) --外键关联
);
select * from job_class
);

--职位分类表
create table job_class(
  jc_id number primary key ,
  jc_name varchar2(30) not null
);
insert into JOB_CLASS values(jobClass_sql.nextval,'编程');

----------------------------------------------------------------------------------

select * from job where c_id=1001
insert into job values(job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary,job_max_salary,job_request)
insert into job values(job_sql.nextval,1001,'编程','qq客服','网络客服','初级客服','3k','3.5k','2017-4-3','研究生')
insert into job values(job_sql.nextval,1001,'编程','微信客服','网络客服','初级客服','3k','5k','2017-4-3','本科')

update job set job_request='清华硕士' where job_id=1001
--select tkfuser_sql.nextval from dual;
--drop sequence jobcalss_sql--用户信息序列
alter table tkfuser modify (us_id varchar2(30));
--	删除表
drop table admin;
drop table login;
drop table tkfuser;--用户基本信息
	drop table usResume;--信息
		drop table educationa;--教育信息
		drop table experience;--工作经验
		drop table collect;	--收藏
		drop table take;	--订阅
	drop table resume
drop table company;--公司基本信息
	drop table coResume;--信息
	drop table company_team;
		drop table tag;--公司标签
--		drop table invest;--投资机构
--		drop table tag;--公司标签
	drop table job_class; --职位类别
	drop table job;--职位信息
	drop table product;
--	删除序列
drop sequence admin_sql;
drop sequence login_sql;
drop sequence tkfuser_sql;
	drop sequence usResume_sql;
	  drop sequence experience_job_sql;        
	  drop sequence educationa_sql;
	  drop sequence collect_sql;
	  drop sequence take_job_sql;
drop sequence company_sql;
drop sequence resume_sql;
	  drop sequence comResume_sql;
	  drop sequence company_team_sql;
		drop sequence tag_sql;
		drop sequence invest_sql;
	drop sequence jobClass_sql;
		drop sequence job_sql;
--创建序列
--select sequence
create sequence admin_sql INCREMENT BY 1 START WITH 1001 ;--管理员序列序列
create sequence login_sql INCREMENT BY 1 START WITH 1001 ;--登录序列
create sequence tkfuser_sql INCREMENT BY 1 START WITH 1001 ;--个人信息序列
create sequence usResume_sql INCREMENT BY 1 START WITH 1001 ;--简历序列
  create sequence experience_job_sql INCREMENT BY 1 START WITH 1001 ;--工作经历序列
  create sequence educationa_sql INCREMENT BY 1 START WITH 1001 ;--学历序列
  create sequence collect_sql INCREMENT BY 1 START WITH 1001 ;--收藏序列
  create sequence take_job_sql INCREMENT BY 1 START WITH 1001 ;--订阅序列
create sequence company_sql INCREMENT BY 1 START WITH 1001 ;--公司序列
  create sequence resume_sql INCREMENT BY 1 START WITH 1001 ;--简历
create sequence comResume_sql INCREMENT BY 1 START WITH 1001 ;--公司简历/信息序列
	create sequence company_team_sql INCREMENT BY 1 START WITH 1001 ;
create sequence jobClass_sql INCREMENT BY 1 START WITH 1001 ;--职位类别序列
	create sequence job_sql INCREMENT BY 1 START WITH 1001 ;--职位序列
