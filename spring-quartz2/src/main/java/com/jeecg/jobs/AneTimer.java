package com.jeecg.jobs;

import java.io.Serializable;

public class AneTimer implements Serializable {

	private String jobname;

	private String jobgroup;

	private String cronexpression;

	public String getJobname() {
		return jobname;
	}

	public String getJobgroup() {
		return jobgroup;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public void setJobgroup(String jobgroup) {
		this.jobgroup = jobgroup;
	}

	public String getCronexpression() {
		return cronexpression;
	}

	public void setCronexpression(String cronexpression) {
		this.cronexpression = cronexpression;
	}

}
