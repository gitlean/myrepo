package com.isoft.scheduler.quartz;


import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.entity.JobLog;
import com.isoft.scheduler.services.JobService;

public abstract class AbstractJobs implements Job {
	private static Logger logger = LoggerFactory.getLogger(AbstractJobs.class);
	@Autowired
	private JobService jobService;
	
	private Long startTime;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		boolean succeed = true;
		this.preExecute();

		try {
			this.executeIntenal(context);
		} catch (Exception arg3) {
			succeed = false;
			logger.error("jobExecuteError------jobName:" + context.getJobDetail().getJobDataMap().getString("jobName"),
					arg3);
			arg3.printStackTrace();
		}

		this.postExecute(context, succeed);
	}
	
	
	

	private void preExecute() {
		this.startTime = Long.valueOf(System.currentTimeMillis());
	}

	private void postExecute(JobExecutionContext context, boolean succeed) {
		String jobName = context.getJobDetail().getJobDataMap().getString("jobName");
		String jobType = context.getJobDetail().getJobDataMap().getString("jobType");
		String tempExec = context.getTrigger().getJobDataMap().getString("tempExec");
		JobEntity jobEntity = this.jobService.getJobEntity(jobName, jobType);
		if (jobEntity == null) {
			logger.error("job不存在, jobName:" + jobName);
		} else {
			if (succeed) {
				if (context.getFireTime() != null) {
					jobEntity.setRuntimeLast(context.getFireTime());
				}

				if (StringUtils.isBlank(tempExec)) {
					jobEntity.setJobStatus("3");
					if (context.getNextFireTime() != null) {
						jobEntity.setRuntimeNext(context.getNextFireTime());
					} else {
						jobEntity.setRuntimeNext((Date) null);
						jobEntity.setJobStatus("6");
					}
				}

				jobEntity.setRunTimes(
						Integer.valueOf(jobEntity.getRunTimes() == null ? 1 : jobEntity.getRunTimes().intValue() + 1));
				jobEntity.setRunDuration(Long.valueOf(System.currentTimeMillis() - this.startTime.longValue()));
			} else {
				jobEntity.setJobStatus("5");
			}

			this.jobService.updateJob(jobEntity);
			this.addLog(jobEntity);
		}
	}

	private void addLog(JobEntity jobEntity) {
		JobLog log = new JobLog();

		try {
			BeanUtils.copyProperties(log, jobEntity);
			log.setId((String) null);
			log.setCreateDate(new Date());
			this.jobService.addLog(log);
		} catch (Exception arg3) {
			arg3.printStackTrace();
			logger.error("error happens whose jobName is:" + jobEntity.getJobName(), arg3);
		}

	}

	public abstract void executeIntenal(JobExecutionContext arg0) throws Exception;
}