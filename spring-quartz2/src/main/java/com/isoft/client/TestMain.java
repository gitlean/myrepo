package com.isoft.client;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.isoft.jobs.pickNewsJob;

public class TestMain {

	public static void main(String args[]) throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(pickNewsJob.class).withIdentity("job1", "jgroup1").build();
		SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 2)).startNow().build();

		// 创建scheduler
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.scheduleJob(jobDetail, simpleTrigger);
		scheduler.start();
	}

}
