package com.xxx.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.xxx.system.event.MonitorLogEvent;

@Component
public class MonitorLogEventListener implements ApplicationListener<MonitorLogEvent> {

	private static Logger logger=LoggerFactory.getLogger(MonitorLogEventListener.class);
	//@Autowired
	//private MonitorLogService logService   // 用于实现保存的业务逻辑

	public void onApplicationEvent(MonitorLogEvent event) {
		if(event instanceof MonitorLogEvent){
			MonitorLogEvent logEvent=(MonitorLogEvent)event;
			logger.debug("保存日志信息到数据库"+logEvent.getMonitorLog().toString());
		}
		
	}
	
	
	

}
