package com.isoft.scheduler.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;

//@Entity(name = "jobEntity")
//@Table(name = "QUARTZ_JOBS")
public class JobEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient
	private static final String IDENTIFY_JOB_PREFIX = "job_";
	@Transient
	private static final String IDENTIFY_TRIGGER_PREFIX = "trigger_";
	@Transient
	private String uuid;
	
	@Id
	@Column(name="ID")
	private String jobId;
	
	@Column(name = "JOB_NAME", length = 100, nullable = false)
	private String jobName;
	
	@Column(name = "JOB_TYPE", length = 100, nullable = false)
	private String jobType;
	
	@Column(name = "TRIGGER_NAME", length = 100, nullable = false)
	private String triggerName;
	
	@Column(name = "TRIGGER_TYPE", length = 100, nullable = false)
	private String triggerType;
	
	@Column(name = "CRON_EXPR", length = 20, nullable = false)
	private String cronExpression;
	
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "RUNTIME_LAST")
	private Date runtimeLast;
	
	@Column(name = "RUNTIME_NEXT")
	private Date runtimeNext;
	
	@Column(name = "JOB_STATUS", length = 2)
	private String jobStatus;
	
	@Column(name = "RUN_TIMES")
	private Integer runTimes;
	
	@Column(name = "RUN_DURATION", length = 20)
	private Long runDuration;
	
	@Column(name = "SYNC_START_DATE")
	private Date syncStartDate;
	
	@Column(name = "SYNC_END_DATE")
	private Date syncEndDate;
	
	@Column(name = "JOB_CLASS", length = 50)
	private String jobClass;
	
	@Column(name = "JOB_METHOD", length = 50)
	private String jobMethod;

	public String getJobName() {
		this.generateJobIdent();
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getTriggerName() {
		this.generateJobIdent();
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
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

	public Date getRuntimeLast() {
		return this.runtimeLast;
	}

	public void setRuntimeLast(Date runtimeLast) {
		this.runtimeLast = runtimeLast;
	}

	public Date getRuntimeNext() {
		return this.runtimeNext;
	}

	public void setRuntimeNext(Date runtimeNext) {
		this.runtimeNext = runtimeNext;
	}

	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Integer getRunTimes() {
		return this.runTimes;
	}

	public void setRunTimes(Integer runTimes) {
		this.runTimes = runTimes;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	private void generateJobIdent() {
		if (StringUtils.isBlank(this.jobName) || StringUtils.isBlank(this.triggerName)) {
			this.uuid = UUID.randomUUID().toString();
			this.jobName = "job_" + this.uuid;
			this.triggerName = "trigger_" + this.uuid;
		}

	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void copyValues(JobEntity currentJob) {
		this.name = currentJob.getName();
		this.jobType = currentJob.getJobType();
		this.triggerType = currentJob.getTriggerType();
		this.jobClass = currentJob.getJobClass();
		this.jobMethod = currentJob.getJobMethod();
		this.syncStartDate = currentJob.getSyncStartDate();
		this.syncEndDate = currentJob.getSyncEndDate();
		this.cronExpression = currentJob.getCronExpression();
	}

	public String toString() {
		return "JobEntity [jobName=" + this.jobName + ", jobType=" + this.jobType + ", triggerName=" + this.triggerName
				+ ", triggerType=" + this.triggerType + ", cronExpression=" + this.cronExpression + ", name="
				+ this.name + ", runtimeLast=" + this.runtimeLast + ", runtimeNext=" + this.runtimeNext + ", jobStatus="
				+ this.jobStatus + ", runTimes=" + this.runTimes + ", runDuration=" + this.runDuration
				+ ", syncStartDate=" + this.syncStartDate + ", syncEndDate=" + this.syncEndDate + ", jobClass="
				+ this.jobClass + ", jobMethod=" + this.jobMethod + "]";
	}
}