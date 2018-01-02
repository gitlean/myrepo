package com.isoft.scheduler.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity(name = "jobLog")
//@Table(name = "QUARTZ_JOB_LOG")
public class JobLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "JOB_NAME", length = 100)
	private String jobName;

	@Column(name = "JOB_TYPE", length = 100)
	private String jobType;

	@Column(name = "TRIGGER_NAME", length = 100)
	private String triggerName;

	@Column(name = "TRIGGER_TYPE", length = 100)
	private String triggerType;

	@Column(name = "CRON_EXPR", length = 20)
	private String cronExpression;

	@Column(name = "JOB_STATUS", length = 2)
	private String jobStatus;

	@Column(name = "RUN_DURATION", length = 20)
	private Long runDuration;

	@Column(name = "JOB_CLASS", length = 200)
	private String jobClass;

	@Column(name = "JOB_METHOD", length = 20)
	private String jobMethod;

	@Column(name = "SYNC_START_DATE")
	private Date syncStartDate;

	@Column(name = "SYNC_END_DATE")
	private Date syncEndDate;

	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;

	@Transient
	private double durationSeconds;

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getTriggerName() {
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerType() {
		return this.triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Long getRunDuration() {
		return this.runDuration;
	}

	public void setRunDuration(Long runDuration) {
		this.runDuration = runDuration;
	}

	public String getJobClass() {
		return this.jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getJobMethod() {
		return this.jobMethod;
	}

	public void setJobMethod(String jobMethod) {
		this.jobMethod = jobMethod;
	}

	public Date getSyncStartDate() {
		return this.syncStartDate;
	}

	public void setSyncStartDate(Date syncStartDate) {
		this.syncStartDate = syncStartDate;
	}

	public Date getSyncEndDate() {
		return this.syncEndDate;
	}

	public void setSyncEndDate(Date syncEndDate) {
		this.syncEndDate = syncEndDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getDurationSeconds() {
		if (this.runDuration != null && this.runDuration.longValue() != 0L) {
			this.durationSeconds = this.runDuration.doubleValue() / 1000.0D;
		}

		return this.durationSeconds;
	}

	public void setDurationSeconds(double durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
