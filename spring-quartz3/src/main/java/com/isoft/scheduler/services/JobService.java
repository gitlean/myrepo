package com.isoft.scheduler.services;

import java.util.List;
import java.util.Map;

import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.entity.JobLog;

public interface JobService {
	List<JobEntity> lazyJobList(Map<String, Object> arg0, int arg1, int arg2);

	int lazyJobListSize(Map<String, Object> arg0);

	List<JobLog> lazyLogList(Map<String, Object> arg0, int arg1, int arg2);

	int lazyLogListSize(Map<String, Object> arg0);

	JobEntity getJobEntity(String jobName, String jobType);

	List<JobEntity> getActiveJobs();

	void updateJob(JobEntity jobEntity);

	boolean saveAndCreate(JobEntity currentJob);

	boolean updateAndResume(JobEntity currentJob);

	boolean pauseJob(JobEntity currentJob);

	boolean resumeTrigger(JobEntity currentJob);

	boolean executeJob(JobEntity currentJob);

	void addLog(JobLog arg0);

	JobEntity getJobById(String jobId);
}
