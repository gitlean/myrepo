package com.isoft.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.isoft.entity.RiskEarlyWarn;
import com.isoft.event.EarlyWarnPublishEvent;

/**
*@author anonymous
*@createTime 2020年11月5日 下午1:11:08
*@describe  Service层：执行用户注册，并发布事件
*
*    实现 ApplicationEventPublisherAware
*/
@Service("earlyWarnPublish")
public class EarlyWarnPublishImpl implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
		
	}

	// 在AOP 配置 调用，
	public boolean register(RiskEarlyWarn riskEarlyWarn) {
        //消息发布   listener会捕获
        applicationEventPublisher.publishEvent(new EarlyWarnPublishEvent(this, riskEarlyWarn));

        return true;
    }
}
