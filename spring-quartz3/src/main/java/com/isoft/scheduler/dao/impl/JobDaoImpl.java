package com.isoft.scheduler.dao.impl;

import java.util.List;
import java.util.Map;

import com.isoft.scheduler.dao.JobDao;
import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.entity.JobLog;

public class JobDaoImpl implements JobDao {

	public List<JobEntity> lazyJobList(Map<String, Object> criteriaMap, int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public int lazyJobListSize(Map<String, Object> criteriaMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<JobLog> lazyLogList(Map<String, Object> criteriaMap, int first, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public int lazyLogListSize(Map<String, Object> criteriaMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	public JobEntity getJobEntity(String jobName, String jobType) {
		// TODO Auto-generated method stub
		return null;
	}

	public JobEntity getJobById(String jobId) {
		// TODO Auto-generated method stub
		return null;
	}

}
