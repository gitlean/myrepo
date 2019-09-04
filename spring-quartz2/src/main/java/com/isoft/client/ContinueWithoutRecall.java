package com.isoft.client;

import java.util.List;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

//如果我们不想执行新的任务，只想纯粹地恢复之前异常中断任务，
public class ContinueWithoutRecall {

	public static void main(String[] args) {// 调用此方法，我们在数据库中异常中断任务记录就会被读取执行，然后被删除掉。

		try {
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			// ①获取调度器中所有的触发器组
			List<String> triggerGroups = scheduler.getTriggerGroupNames();
			// ②重新恢复在tgroup1组中，名为trigger1触发器的运行
			for (int i = 0; i < triggerGroups.size(); i++) {// 这里使用了两次遍历，针对每一组触发器里的每一个触发器名，和每一个触发组名进行逐次匹配
				List<String> triggers = scheduler.getTriggerGroupNames();
				for (int j = 0; j < triggers.size(); j++) {
					Trigger tg = scheduler.getTrigger(new TriggerKey(triggers.get(j), triggerGroups.get(i)));
					// ②-1:根据名称判断
					if (tg instanceof SimpleTrigger && tg.getDescription().equals("jgroup1.DEFAULT")) {// 由于我们之前测试没有设置触发器所在组，所以默认为DEFAULT
	
						// ②-1:恢复运行
						scheduler.resumeJob(new JobKey(triggers.get(j), triggerGroups.get(i)));
					}
				}
			}
			scheduler.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
