package com.jeecg.timer;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jeecg.jobs.AneTimer;
import com.jeecg.utils.SpringContextUtil;

/**
 * **************************************************************** 文件名称
 * :QuartzManager.java 创建时间 : 2015年9月17日 上午10:19:46 文件描述 : 定时任务管理类 版权声明 :
 * 修改历史:2015年9月17日 1.00 初始版本
 *****************************************************************
 */
@Service
public class QuartzManager {
	private final static Logger log = LoggerFactory.getLogger(QuartzManager.class);

	private static Scheduler sched;

	/**
	 * 获取调度器
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	public static Scheduler getScheduler() throws SchedulerException {
		if (sched == null) {
			sched = (Scheduler) SpringContextUtil.getBean("schedulerFactoryBean");// 获取由这个工厂创建的对象实例
		}
		return sched;
	}

	/**
	 * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
	 * 
	 * @param myJob
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addJob(AneTimer myJob, Class cls) { // Class cls是具体执行的内容
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:addJob  start");
		try {
			Scheduler scheduler = getScheduler();

			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (null == cronTrigger) {
				
				
				JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(jobName, jobGroup).build();

				cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
						.withSchedule(CronScheduleBuilder.cronSchedule(myJob.getCronexpression())).build();
				// cronTrigger.getJobDataMap().put("jobEntity", myJob);

				scheduler.scheduleJob(jobDetail, cronTrigger);
				// 启动一个定时器
				if (!scheduler.isShutdown()) {
					scheduler.start();
				}
			} else {
				cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey)
						.withSchedule(CronScheduleBuilder.cronSchedule(myJob.getCronexpression())).build();
				scheduler.rescheduleJob(triggerKey, cronTrigger);
			}
			// 等待启动完成
			// Thread.sleep(TimeUnit.SECONDS.toMillis(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:addJob  end");
	}

	/**
	 * @Description: 暂停一个任务
	 * 
	 * @param myJob
	 * 
	 */
	public static void pasueOneJob(AneTimer myJob) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:pasueOneJob  start");
		try {
			Scheduler scheduler = getScheduler();
			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			// if(null==trigger){
			// log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:removeJob trigger
			// is NULL ");
			// return;
			// }
			JobKey jobKey = trigger.getJobKey();
			scheduler.pauseJob(jobKey);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:pasueOneJob  end");
	}

	/**
	 * @Description: 重启一个任务
	 * 
	 * @param myJob
	 * 
	 */
	public static void resOneJob(AneTimer myJob) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:resOneJob  start");
		try {
			Scheduler scheduler = getScheduler();
			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			// if(null==trigger){
			// log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:removeJob trigger
			// is NULL ");
			// return;
			// }
			scheduler.rescheduleJob(triggerKey, trigger);

			// Thread.sleep(TimeUnit.MINUTES.toMillis(10));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:resOneJob  end");
	}

	/**
	 * @Description: 修改一个任务的触发时间
	 * 
	 * @param jobName
	 */
	public static void modifyJobTime(AneTimer myJob, String time) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:modifyJobTime  start");
		try {
			Scheduler scheduler = getScheduler();
			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			myJob.setCronexpression(time);
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(myJob.getCronexpression());
			cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder)
					.build();
			scheduler.rescheduleJob(triggerKey, cronTrigger);

			// Thread.sleep(TimeUnit.MINUTES.toMillis(60));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:modifyJobTime  end");
	}

	/**
	 * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
	 * 
	 * @param jobName
	 * 
	 */
	public static void removeJob(AneTimer myJob) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:removeJob  start");
		try {
			Scheduler scheduler = getScheduler();
			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			if (null == trigger) {
				log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:removeJob trigger is NULL ");
				return;
			}
			JobKey jobKey = trigger.getJobKey();
			scheduler.pauseTrigger(triggerKey);// 停止触发器
			scheduler.unscheduleJob(triggerKey);// 移除触发器
			scheduler.deleteJob(jobKey);// 删除任务

			// Thread.sleep(TimeUnit.MINUTES.toMillis(10));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:removeJob  end");
	}

	/**
	 * 
	 * 方法表述 获得执行器状态
	 * 
	 * @return String
	 */
	public static String getStatus(AneTimer myJob) {
		String state = "NONE";
		try {
			Scheduler scheduler = getScheduler();
			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			// trigger state
			TriggerState triggerState = scheduler.getTriggerState(triggerKey);
			state = triggerState.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return state;
	}

	/**
	 * 是否存在任务 方法表述
	 * 
	 * @param myJob
	 * @return boolean
	 */
	public static boolean hasTrigger(AneTimer myJob) {
		boolean isHas = true;
		try {
			Scheduler scheduler = getScheduler();
			// 唯一主键
			String jobName = myJob.getJobname();
			String jobGroup = myJob.getJobgroup();
			TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
			Trigger trigger = scheduler.getTrigger(triggerKey);
			if (null == trigger) {
				log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>method:removeJob trigger is NULL ");
				isHas = false;
			}
		} catch (SchedulerException e) {
			isHas = false;
			e.printStackTrace();
		}
		return isHas;
	}

	/**
	 * @Description:启动所有定时任务
	 * 
	 */
	public static void startJobs() {
		try {
			Scheduler sched = getScheduler();
			sched.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:关闭所有定时任务
	 * 
	 */
	public static void shutdownJobs() {
		try {
			Scheduler sched = getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
