drop database if exists jdbc;
CREATE DATABASE IF NOT EXISTS jdbc;
USE jdbc;
 
drop table if exists user ;
CREATE TABLE IF NOT EXISTS `user ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  ` name` varchar(50) DEFAULT NULL ,
  `pwd` varchar(50) DEFAULT NULL ,
  PRIMARY KEY (`id`)
) ;
#数据初始化
insert into user values (null ,'zhangsan' ,'123456' );
insert into user values (null ,'lisi' ,'123456' );