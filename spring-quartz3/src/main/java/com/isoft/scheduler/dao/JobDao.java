package com.isoft.scheduler.dao;

import java.util.List;
import java.util.Map;

import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.entity.JobLog;

public interface JobDao {
	
	List<JobEntity> lazyJobList(Map<String,Object> criteriaMap,int first,int pageSize);
	
	int lazyJobListSize(Map<String,Object> criteriaMap);
	
    List<JobLog> lazyLogList(Map<String,Object> criteriaMap,int first,int pageSize);
    
    int lazyLogListSize(Map<String,Object> criteriaMap);
    
    JobEntity getJobEntity(String jobName,String jobType);
    
    JobEntity getJobById(String jobId); 
	
}
