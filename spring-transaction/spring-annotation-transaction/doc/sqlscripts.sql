--首先是数据库表
book(isbn, book_name, price)
account(username, balance)
book_stock(isbn, stock)

-----------------------------------------------

tbl_student

create table tbl_student(
	id int not null primary key auto_increment,
	name varchar(32),
	birth date,
	score float
);

truncate table tbl_student;
select * from tbl_student;

insert into tbl_student(name) value('Tom');





