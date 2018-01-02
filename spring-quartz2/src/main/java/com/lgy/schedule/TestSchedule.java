package com.lgy.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lgy.service.MyserviceInterface;

//定时任务类(前提需要给Spring扫描器进行扫描)
@Component
public class TestSchedule {
	@Autowired
	private MyserviceInterface myserviceInterface;

	//@Scheduled是Quartz的一个注解类，cron是定时表达式。 
	@Scheduled(cron = "0/5 * *  * * ? ") // 每5秒执行一次
	public void run() {
		System.out.println(myserviceInterface.fun(99999));
		System.out.println("执行了这个线程！");
	}
}