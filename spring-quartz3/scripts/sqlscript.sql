
create table QUARTZ_JOBS
(
	ID varchar(50),
	JOB_NAME varchar(100),
	JOB_TYPE varchar(100),
	TRIGGER_NAME varchar(100),
	TRIGGER_TYPE varchar(100),
	CRON_EXPR varchar(20),
	NAME varchar(50),
	RUNTIME_LAST date,
	RUNTIME_NEXT date,
	JOB_STATUS varchar(2),
	RUN_TIMES number,
	RUN_DURATION number,
	SYNC_START_DATE date,
	SYNC_END_DATE date,
	JOB_CLASS varchar(50),
	JOB_METHOD varchar(50),
	CREATE_BY varchar(50),
	CREATE_DATE date,
	version number
);



create table QUARTZ_JOB_LOG
(
	ID varchar(50),
	JOB_NAME varchar(100),
	JOB_TYPE varchar(100),
	TRIGGER_NAME varchar(100),
	TRIGGER_TYPE varchar(100),
	CRON_EXPR varchar(20),
	JOB_STATUS varchar(2),
	RUN_DURATION number,
	SYNC_START_DATE date,
	SYNC_END_DATE date,
	JOB_CLASS varchar(50),
	JOB_METHOD varchar(50),
	CREATE_DATE date
);





