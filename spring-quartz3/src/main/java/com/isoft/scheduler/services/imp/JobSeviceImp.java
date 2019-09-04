package com.isoft.scheduler.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoft.scheduler.constants.QuartzConstants;
import com.isoft.scheduler.dao.JobDao;
import com.isoft.scheduler.entity.JobEntity;
import com.isoft.scheduler.entity.JobLog;
import com.isoft.scheduler.quartz.SchedulerHelper;
import com.isoft.scheduler.services.JobService;

@Service
public class JobSeviceImp implements JobService {
	
	@Autowired
	private  SchedulerHelper schedulerHelper;
	
	@Autowired
	private JobDao jobDao;

	public List<JobEntity> lazyJobList(Map<String, Object> criteriaMap, int first, int pageSize) {

		return jobDao.lazyJobList(criteriaMap, first, pageSize);
	}

	public int lazyJobListSize(Map<String, Object> criteriaMap) {

		return jobDao.lazyJobListSize(criteriaMap);
	}

	public List<JobLog> lazyLogList(Map<String, Object> criteriaMap, int first, int pageSize) {

		return jobDao.lazyLogList(criteriaMap, first, pageSize);
	}

	public int lazyLogListSize(Map<String, Object> criteriaMap) {

		return jobDao.lazyLogListSize(criteriaMap);
	}
	
	

	public JobEntity getJobEntity(String jobName, String jobType) {
		 
		return jobDao.getJobEntity(jobName, jobType);
	}

	public List<JobEntity> getActiveJobs() {
		
		return null;
	}

	public void updateJob(JobEntity jobEntitty) { //JobEntity更新
		//TODO 
		//jobDao.merge(jobEntitty);

	}

	
	/**
	 * 创建
	 */
	public boolean saveAndCreate(JobEntity currentJob) {
		boolean created=schedulerHelper.createAndStartJob(currentJob);
		if(created){
			if(currentJob.getSyncStartDate() != null && currentJob.getSyncStartDate().after(new Date())){
				currentJob.setJobStatus(QuartzConstants.WAITTING);
			}else{
				currentJob.setJobStatus(QuartzConstants.ACQUIRED);
			}
			
			//TODO
			//jobDao.persist(currentJob);
			
		}

		return created;
	}
	
	/**
	 * 替换/更新
	 */
	public boolean updateAndResume(JobEntity currentJob) {
		JobEntity oldJob=getJobById(currentJob.getJobId());
		boolean updated=schedulerHelper.rescheduleJob(oldJob, currentJob);
		if(updated){
			oldJob.copyValues(currentJob);
			if(oldJob.getSyncStartDate() != null && oldJob.getSyncStartDate().after(new Date())){
				oldJob.setJobStatus(QuartzConstants.WAITTING);
			}else{
				oldJob.setJobStatus(QuartzConstants.ACQUIRED);
			}
			
			//TODO 
			//jobDao.merge(oldJob);
			
		}

		return updated;
	}

	/**
	 * 暂停
	 */
	public boolean pauseJob(JobEntity currentJob) {
		boolean paused=schedulerHelper.pauseJob(currentJob);
		if(paused){
			JobEntity job=getJobById(currentJob.getJobId());
			job.setJobStatus(QuartzConstants.PAUSED);
			//TODO 
			//jobDao.merge(job);
		}
		return paused;
	}

	
	public boolean resumeTrigger(JobEntity currentJob) {
		boolean resumed=schedulerHelper.pauseJob(currentJob);
		if(resumed){
			JobEntity job=getJobById(currentJob.getJobId());
			if(job.getSyncStartDate() != null && job.getSyncStartDate().after(new Date())){
				job.setJobStatus(QuartzConstants.WAITTING);
			}else{
				job.setJobStatus(QuartzConstants.ACQUIRED);
			}

			//TODO 
			//jobDao.merge(job);
		}
		return resumed;
	}
	

	
	public boolean executeJob(JobEntity currentJob) {
		boolean executed=schedulerHelper.executeOnceJob(currentJob);
		return executed;
	}

	public void addLog(JobLog jobLog) {
		// TODO
		// jobDao.persist(jobLog);

	}

	
	/**
	 * 根据jobId获取JobEntity
	 */
	public JobEntity getJobById(String jobId) {
		 
		return jobDao.getJobById(jobId);
	}

}
