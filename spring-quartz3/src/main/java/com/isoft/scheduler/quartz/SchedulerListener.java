package com.isoft.scheduler.quartz;

import org.quartz.SchedulerException;
import org.quartz.listeners.SchedulerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("schedulerListener")
public class SchedulerListener extends SchedulerListenerSupport {

	private static Logger logger = LoggerFactory.getLogger(SchedulerListener.class);
	private SchedulerHelper schedulerHelper;

	public SchedulerHelper getSchedulerHelper() {
		return schedulerHelper;
	}

	public void setSchedulerHelper(SchedulerHelper schedulerHelper) {
		this.schedulerHelper = schedulerHelper;
	}

	@Override
	public void schedulerStarted() {
		try {
			schedulerHelper.createActiveJobs();
		} catch (SchedulerException e) {
			logger.error("createActiveJobs", e);
		}
	}

}
