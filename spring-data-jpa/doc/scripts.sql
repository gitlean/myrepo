create database zhangjp;

use zhangjp;


create table t_userinfo(
	userinfo_id int not null primary key AUTO_INCREMENT,
	username varchar(32),
	password varchar(32)

);

create table t_accountinfo
(
	id int not null primary key AUTO_INCREMENT,
	userInfo int,
	balance int
);


select * from t_userinfo;

select * from t_accountinfo



private Long userid;

private String username;

private String password;

----------------------------
private Long accountId;

private UserInfo userInfo;

private Integer balance;
    