package com.hsoft.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob implements Job {
	private final static Logger logger = LoggerFactory.getLogger(MyJob.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello quzrtz  " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

	}

}
