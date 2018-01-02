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

	JobEntity getJobEntity(String arg0, String arg1);

	List<JobEntity> getActiveJobs();

	void updateJob(JobEntity arg0);

	boolean saveAndCreate(JobEntity arg0);

	boolean updateAndResume(JobEntity arg0);

	boolean pauseJob(JobEntity arg0);

	boolean resumeTrigger(JobEntity arg0);

	boolean executeJob(JobEntity arg0);

	void addLog(JobLog arg0);

	JobEntity getJobById(String jobId);
}
