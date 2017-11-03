package com.xxx.system.event;

import org.springframework.context.ApplicationEvent;

import com.xxx.system.entity.MonitorLog;

public class MonitorLogEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private MonitorLog monitorLog;
	
	public MonitorLogEvent(Object source) {
		super(source);
		
	}
	
	public MonitorLogEvent(Object source,MonitorLog log) {
		super(source);
		this.monitorLog=log;
	}
	
	public MonitorLog getMonitorLog() {
		return monitorLog;
	}

	public void setMonitorLog(MonitorLog monitorLog) {
		this.monitorLog = monitorLog;
	}

	
	
	
}
