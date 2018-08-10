

--oracle-------------------------
CREATE TABLE STUDENT (
	ID NUMBER(5),
	NAME VARCHAR2(10),
	SEX VARCHAR2(10),
	AGE NUMBER(10),
	ADDRESS VARCHAR2(10),
	CONSTRAINT PK_ID PRIMARY KEY(ID)
);

----mysql-------------------------
create database ibatis;
use ibatis;

CREATE TABLE STUDENT (
	ID int,
	NAME VARCHAR(10),
	SEX VARCHAR(10),
	AGE int,
	ADDRESS VARCHAR(10),
	CONSTRAINT PK_ID PRIMARY KEY(ID)
);

select * from STUDENT;

truncate table STUDENT;
--------------------------------------------------


















