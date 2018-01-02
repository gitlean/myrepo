package com.jeecg.client;

import com.jeecg.jobs.AneTimer;
import com.jeecg.service.MyService;
import com.jeecg.timer.QuartzManager;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AneTimer myJob = new AneTimer();
		myJob.setJobname("job1-0001");
		myJob.setJobgroup("iob1");

		myJob.setCronexpression("*/2 * * * * ?");

		QuartzManager.addJob(myJob, MyService.class);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QuartzManager.modifyJobTime(myJob, "*/5 * * * * ?");
	}

}
