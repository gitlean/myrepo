package com.isoft.scheduler.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.quartz.SchedulerHelper;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		SchedulerHelper schedulerHelper = (SchedulerHelper) ctx.getBean("schedulerHelper");

		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("-------------------------");
		JobEntity jobEntity = new JobEntity();
		jobEntity.setJobName("job_N_1");
		jobEntity.setJobType("job_Type_1");
		jobEntity.setTriggerName("Trigger_N_1");
		jobEntity.setTriggerType("Trigger_Type_1");
		jobEntity.setJobClass("myJob");
		jobEntity.setJobMethod("execute1");

		jobEntity.setCronExpression("*/2 * * * * ?");

		schedulerHelper.createAndStartJob(jobEntity); // 创建并启动

//		try {
//			Thread.currentThread().sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//schedulerHelper.pauseJob(jobEntity);

		//schedulerHelper.resumeTrigger(jobEntity); //重启

		//schedulerHelper.executeOnceJob(jobEntity);
		

	}
}
