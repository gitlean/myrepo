package com.isoft.scheduler.services.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.entity.JobLog;
import com.isoft.scheduler.services.JobService;

@Service
public class JobSeviceImp implements JobService {

	public List<JobEntity> lazyJobList(Map<String, Object> arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public int lazyJobListSize(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<JobLog> lazyLogList(Map<String, Object> arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public int lazyLogListSize(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public JobEntity getJobEntity(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<JobEntity> getActiveJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateJob(JobEntity arg0) {
		// TODO Auto-generated method stub

	}

	public boolean saveAndCreate(JobEntity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateAndResume(JobEntity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean pauseJob(JobEntity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean resumeTrigger(JobEntity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean executeJob(JobEntity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addLog(JobLog arg0) {
		// TODO Auto-generated method stub

	}

	public JobEntity getJobById(String jobId) {
		// TODO Auto-generated method stub
		return null;
	}

}
