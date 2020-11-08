package com.isoft.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.isoft.event.EarlyWarnPublishEvent;

/**
*@author anonymous
*@createTime 2020年11月5日 下午1:13:18
*@describe  事件监听：监听到事件发布后，自动执行onApplicationEvent方法，
*                    所以该类需要有IOC来管理，类上要加@Component注解
*/
@Component
public class EventListener implements ApplicationListener<EarlyWarnPublishEvent> {

	@Override
	public void onApplicationEvent(EarlyWarnPublishEvent earlyWarnPublishEvent) {
		System.out.println("id： " + earlyWarnPublishEvent.getEarlyWarnInfo().getEarlyWarnId());

        //发短信
        System.out.println("info： " + earlyWarnPublishEvent.getEarlyWarnInfo().getEarlyWarnCondition());
	}

	
	
	
}
