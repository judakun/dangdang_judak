select f.f_id fid,f.f_name fname,f.f_levels flevel,f.f_parent_id fpid,s.f_id sid,s.f_name sname 
		from d_category f
		left join d_category s 
		on f.f_id=s.f_parent_id
		where f.f_levels='1'

select * from d_book where b_name='BBC科普三部曲（地球+生命+海洋） '

select * from d_book


select f.f_id fid,f.f_name fname,f.f_levels flevel,f.f_parent_id fpid,s.f_id sid,s.f_name sname,s.f_parent_id sfid 
		from d_category f
		left join d_category s 
		on f.f_parent_id=s.f_id
		
select * from d_book 
where
b_category_id in (select f_id from d_category where f_parent_id='f4')



alter table d_address
   drop constraint FK_D_ADDRES_REFERENCE_D_USER;

alter table d_book
   drop constraint FK_D_BOOK_REFERENCE_D_CATEGO;

alter table d_item
   drop constraint FK_D_ITEM_REFERENCE_D_ORDER;

alter table d_item
   drop constraint FK_D_ITEM_REFERENCE_D_BOOK;

alter table d_order
   drop constraint FK_D_ORDER_REFERENCE_D_USER;

drop table d_address cascade constraints;

drop table d_book cascade constraints;

drop table d_category cascade constraints;

drop table d_item cascade constraints;

drop table d_manager cascade constraints;

drop table d_order cascade constraints;

drop table d_user cascade constraints;

/*==============================================================*/
/* Table: d_address                                             */
/*==============================================================*/
create table d_address  (
   d_id                 varchar2(36)                    not null,
   d_name               varchar2(100),
   d_local              varchar2(300),
   d_phone              varchar2(11),
   d_zipCode            varchar2(10),
   user_id              varchar2(36),
   constraint PK_D_ADDRESS primary key (d_id)
);
insert into d_address values()
/*==============================================================*/
/* Table: d_book                                                */
/*==============================================================*/
create table d_book  (
   b_id                 varchar2(36)                    not null,
   b_name               varchar2(30),
   b_price              number(10,2),
   b_dprice             number(10,2),
   b_author             varchar2(50),
   b_category_id        varchar2(36),
   b_intro              varchar2(512),
   b_auIntro            varchar2(256),
   b_cbs                varchar2(50),
   b_cbDate             Date,
   b_ysDate             Date,
   b_bc                 varchar2(50),
   b_yc                 varchar2(50),
   b_zz                 varchar2(30),
   b_page               number(10),
   b_bz                 varchar2(50),
   b_kb                 varchar2(50),
   b_words              number(10),
   ISBN                 varchar2(50),
   b_bjtj               varchar2(50),
   b_mtpl               varchar2(256),
   b_jbml               varchar2(512),
   b_face               varchar2(50),
   b_kc                 number(10),
   b_saleNum            number(10)
);
drop table d_book
insert into d_book values();
select * from d_book where b_name like '%黄%'
delete d_book where b_id='2a5bb175-fc1d-4402-9b65-bc01be65a8cf';
commit;
/*==============================================================*/
/* Table: d_category                                            */
/*==============================================================*/
create table d_category  (
   f_id                 varchar2(36)                    not null,
   f_name               varchar2(100),
   f_parent_id          varchar2(36),
   f_levels             varchar2(5),
   constraint PK_D_CATEGORY primary key (f_id)
);
drop table d_category
insert into d_category values('f1','小说',null,'1');
insert into d_category values('f2','都市','f1','2');
insert into d_category values('f3','言情','f1','2');
insert into d_category values('f4','科普','','1');
commit;
select * from d_category where f_name='测试一级类别';
delete d_category where f_name='测试一级类别';
commit;

select e.f_id,e.* from (
select * from d_category c 
left join d_book b on c.f_id=b.b_category_id
where c.f_levels = '2') e
group by e.f_id


select f.f_id fid,f.f_name fname,f.f_levels flevel,s.f_id sid,s.f_name sname 
from d_category f
left join d_category s 
on f.f_parent_id=s.f_id

/*==============================================================*/
/* Table: d_item                                                */
/*==============================================================*/
create table d_item  (
   ob_id                varchar2(36)                    not null,
   book_id              varchar2(36),
   item_id              varchar2(36),
   ob_count             number(10),
   ob_createDate        date,
   ob_BName             varchar2(100),
   ob_YPrice            number(10,2),
   ob_XPrice            number(10,2),
   ob_BCover            varchar2(100),
   constraint PK_D_ITEM primary key (ob_id)
);
select * from d_item
/*==============================================================*/
/* Table: d_manager                                             */
select m_id,m_username,m_password from d_manager 
		where m_username='admin'
		/*==============================================================*/


create table d_manager  (
   m_id                 varchar2(36)                    not null,
   m_username           varchar2(100),
   m_password           varchar2(100),
   constraint PK_D_MANAGER primary key (m_id)
);
insert into d_manager values('001','admin','admin');commit;
select * from d_manager
/*==============================================================*/
/* Table: d_order                                               */
/*==============================================================*/
create table d_order  (
   o_id                 varchar2(36)                    not null,
   o_orderNum           varchar2(40),
   o_total              number(10,2),
   o_createDate         date,
   user_id              varchar2(36),
   o_toAddress          varchar2(100),
   o_toUName            varchar2(100),
   constraint PK_D_ORDER primary key (o_id)
);
select * from d_order
delete d_order;
commit;
/*==============================================================*/
/* Table: d_user                                                */
/*==============================================================*/
create table d_user  (
   u_id                 varchar2(36)                    not null,
   u_nickname           varchar2(60),
   u_email              varchar2(30),
   u_password           varchar2(60),
   u_status             varchar2(10),
   u_code               varchar2(10),
   u_salt               varchar2(10),
   u_createDate         date,
   constraint PK_D_USER primary key (u_id)
);
insert into d_user values("U003","qqq","999@qq.com","qqq","激活","123","盐",to_date("2005-09-10",));
insert into d_user values('u_id','u_name','u_email','u_password','u_status','u_code','u_salt',sysdate);
commit;
select * from d_user
update d_user set u_code='123456' 
where u_id='d86b45f9-3c7b-4fd8-8d13-5b1edc774359'

alter table d_address
   add constraint FK_D_ADDRES_REFERENCE_D_USER foreign key (user_id)
      references d_user (u_id);

alter table d_book
   add constraint FK_D_BOOK_REFERENCE_D_CATEGO foreign key (b_category_id)
      references d_category (f_id);

alter table d_item
   add constraint FK_D_ITEM_REFERENCE_D_ORDER foreign key (item_id)
      references d_order (o_id);

alter table d_item
   add constraint FK_D_ITEM_REFERENCE_D_BOOK foreign key (book_id)
      references d_book (b_id);

alter table d_order
   add constraint FK_D_ORDER_REFERENCE_D_USER foreign key (user_id)
      references d_user (u_id);
