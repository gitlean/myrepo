create table TB_USER
(
	id int  primary key auto_increment,
	name varchar(32),
	age int
);



select * from TB_USER;


insert into TB_USER('Tom',23);
