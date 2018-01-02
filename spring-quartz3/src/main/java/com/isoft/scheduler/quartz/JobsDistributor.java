package com.isoft.scheduler.quartz;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.isoft.utils.SpringContextHelper;

@Component("jobsDistributor")
public class JobsDistributor extends AbstractJobs {
	private static Logger log = LoggerFactory.getLogger(JobsDistributor.class);

	public void executeIntenal(JobExecutionContext context) throws Exception {
		String jobClass = context.getJobDetail().getJobDataMap().getString("jobClass");
		String jobMethod = context.getJobDetail().getJobDataMap().getString("jobMethod");
		Object obj = SpringContextHelper.getBean(jobClass);
		Method method = obj.getClass().getMethod(jobMethod, new Class[0]);
		method.invoke(obj, new Object[0]);
	}
}