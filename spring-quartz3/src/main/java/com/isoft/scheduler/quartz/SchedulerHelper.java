package com.isoft.scheduler.quartz;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.services.JobService;

@Component("schedulerHelper")
public class SchedulerHelper {
	private static Logger logger = LoggerFactory.getLogger(SchedulerHelper.class);
	private static final String IDENTIFY_TRIGGER_PREFIX = "trigger_";
	@Autowired
	private SchedulerListener schedulerListener;
	@Autowired
	private JobService jobService;
	@Autowired
	private Scheduler scheduler;

	public void startScheduler() {
		try {
			this.scheduler = StdSchedulerFactory.getDefaultScheduler();
			this.schedulerListener.setSchedulerHelper(this);
			this.scheduler.getListenerManager().addSchedulerListener(this.schedulerListener);
			this.scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}

	}

	public boolean createAndStartJob(JobEntity jobEntity) {
		JobDetail jobDetail = generateJobDetail(jobEntity);
		TriggerBuilder trigger = generateTriggerBuilder(jobEntity);

		try {
			if (this.scheduler.checkExists(getJobKey(jobEntity))) {
				this.scheduler.scheduleJob(trigger.build());// 调度
			} else {
				this.scheduler.scheduleJob(jobDetail, trigger.build());
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return false;
		}
	}

	public void clearAllScheduler() {
		try {
			this.scheduler.clear();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}

	}

	/**
	 * 删除相关的job任务
	 * 
	 * @param jobEntity
	 * @return
	 */
	public boolean removeJob(JobEntity jobEntity) {
		try {
			// deleteJob(JobKey jobkey)
			this.scheduler.deleteJob(getJobKey(jobEntity.getJobName(), jobEntity.getJobType()));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return false;
		}
	}

	/**
	 * 停止一个job任务
	 * 
	 * @param jobEntity
	 * @return
	 */
	public boolean pauseJob(JobEntity jobEntity) {
		try {
			// pauseJob(JobKey jobkey)
			this.scheduler.pauseJob(getJobKey(jobEntity.getJobName(), jobEntity.getJobType()));
			return true;
		} catch (Exception arg2) {
			arg2.printStackTrace();
			logger.error("resumeJob", arg2);
			return false;
		}
	}

	public boolean executeOnceJob(JobEntity jobEntity) {
		try {

			// 1、创建一个JobDetail实例，指定Quartz
			JobDataMap jobDataMap = new JobDataMap();
			
			jobDataMap.put("tempExec", Boolean.TRUE.toString());//trigger未设置repeat，这里没什么作用
			
			jobDataMap.put("jobName", jobEntity.getJobName());
			jobDataMap.put("jobType", jobEntity.getJobType());
			
			jobDataMap.put("jobClass", jobEntity.getJobClass());
			jobDataMap.put("jobMethod", jobEntity.getJobMethod());
			Class clazz = JobsDistributor.class;
			JobDetail jobDetail=JobBuilder.newJob(clazz).withIdentity(getJobKey(jobEntity)).usingJobData(jobDataMap).build();
			
			// 2、创建Trigger
			TriggerBuilder simpleTriggerBuilder = TriggerBuilder.newTrigger()
					.withIdentity(getTriggerKey(jobEntity))
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2)).startNow();
			Calendar e = Calendar.getInstance();
			 //add():为给定的日历字段添加或减去指定的时间量  
			e.add(Calendar.SECOND, 2);
			simpleTriggerBuilder.startAt(e.getTime()); //替换simpleTriggerBuilder设置的startNow
			
			e.add(Calendar.SECOND, 3);
			simpleTriggerBuilder.endAt(e.getTime());
			
			Trigger trigger = simpleTriggerBuilder.build();
			
			// 调度执行
			scheduler.scheduleJob(jobDetail,trigger); // 调度(scheduleJob)
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("executeOnceJob", e);
			return false;
		}
	}
	/**
	 * 重新恢复触发器相关的job任务
	 * 
	 * @param oldJob
	 * @param newJob
	 * @return
	 */
	public boolean rescheduleJob(JobEntity oldJob, JobEntity newJob) {
		TriggerKey oldKey = getTriggerKey(oldJob);
		TriggerBuilder trigger = generateTriggerBuilder(newJob);

		try {
			// 重新恢复触发器相关的job任务
			this.scheduler.rescheduleJob(oldKey, trigger.build());// rescheduleJob(triggerkey,
																	// trigger)
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("resumeJob", e);
			return false;
		}
	}

	/**
	 * 
	 * 
	 * @param jobEntity
	 * @return
	 */

	public boolean resumeTrigger(JobEntity jobEntity) {
		TriggerKey trigger = getTriggerKey(jobEntity);

		try {
			// 恢复前需要检查任务状态
			// 得到trigger状态
			TriggerState tstate = scheduler.getTriggerState(trigger);

			if (tstate.equals(TriggerState.NONE)) {//移除
				createAndStartJob(jobEntity);
			} else if (tstate.equals(TriggerState.ERROR)) {

			} else if (tstate.equals(TriggerState.COMPLETE)) {

			} else if (tstate.equals(TriggerState.BLOCKED)) {

			} else {// NORMAL PAUSED
				this.scheduler.resumeTrigger(trigger); // 恢复调度(resumeTrigger,resumeJob)
			}

			return true;
		} catch (SchedulerException arg3) {
			arg3.printStackTrace();
			logger.error("resumeJob", arg3);
			return false;
		}
	}


	// -------------------------------------------------

	public void createActiveJobs() throws SchedulerException {
		List jobLst = this.jobService.getActiveJobs();
		Iterator iter = jobLst.iterator();

		while (iter.hasNext()) {
			JobEntity job = (JobEntity) iter.next();
			if (this.scheduler.getJobDetail(getJobKey(job)) == null) {
				this.createAndStartJob(job);
			}
		}

	}
	// ---------------------------------------------------------------------------------

	public static JobDetail generateJobDetail(JobEntity jobEntity) {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("jobName", jobEntity.getJobName());
		jobDataMap.put("jobType", jobEntity.getJobType());
		jobDataMap.put("triggerName", jobEntity.getTriggerName());
		jobDataMap.put("triggerType", jobEntity.getTriggerType());
		jobDataMap.put("jobClass", jobEntity.getJobClass());
		jobDataMap.put("jobMethod", jobEntity.getJobMethod());
		Class clazz = JobsDistributor.class;

		// abstract class AbstractJobs implements Job
		// JobsDistributor extends AbstractJobs 代理机制
		return JobBuilder.newJob(clazz).withIdentity(getJobKey(jobEntity)).usingJobData(jobDataMap).build();
	}

	/**
	 * 根据传入的jobEntity获取 TriggerBuilder
	 * 
	 * @param jobEntity
	 * @return
	 */
	public static TriggerBuilder<CronTrigger> generateTriggerBuilder(JobEntity jobEntity) {
		TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger()
				.withIdentity(getTriggerKey(jobEntity)).withSchedule(CronScheduleBuilder
						.cronSchedule(jobEntity.getCronExpression()).withMisfireHandlingInstructionDoNothing())
				.forJob(getJobKey(jobEntity));

		if (jobEntity.getSyncStartDate() != null) {
			triggerBuilder.startAt(jobEntity.getSyncStartDate());
		} else {
			triggerBuilder.startNow();
		}

		if (jobEntity.getSyncEndDate() != null) {
			triggerBuilder.endAt(jobEntity.getSyncEndDate());
		}

		return triggerBuilder;
	}

	// ---------------------------------------------------------------------------------

	// 获取JobKey
	public static JobKey getJobKey(JobEntity jobEntity) {
		return new JobKey(jobEntity.getJobName(), jobEntity.getJobType());
	}

	// 获取JobKey
	public static JobKey getJobKey(String jobName, String jobType) {
		return new JobKey(jobName, jobType);
	}

	// 获取TriggerKey
	public static TriggerKey getTriggerKey(JobEntity jobEntity) {
		return new TriggerKey(jobEntity.getTriggerName(), jobEntity.getTriggerType());
	}

	// 生成TriggerKey
	public static TriggerKey generateTriggerKey(JobEntity jobEntity) {
		
		
		
		//return new TriggerKey("trigger_" + UUID.randomUUID().toString(), jobEntity.getTriggerType());
	
		//修改
		return new TriggerKey(jobEntity.getTriggerName(), jobEntity.getTriggerType());
		
	}

}
