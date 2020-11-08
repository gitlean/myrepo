package com.isoft.event;

import org.springframework.context.ApplicationEvent;

import com.isoft.entity.RiskEarlyWarn;

/**
 * @author anonymous
 * @createTime 2020年11月5日 下午1:07:52
 * @describe  事件类：
 */
public class EarlyWarnPublishEvent extends ApplicationEvent {


	private static final long serialVersionUID = 1L;

	
	private RiskEarlyWarn riskEarlyWarn;// even包含     消息

	public EarlyWarnPublishEvent(Object source,RiskEarlyWarn riskEarlyWarn) {
		super(source);
		 
		this.riskEarlyWarn = riskEarlyWarn;
	}

	public RiskEarlyWarn getEarlyWarnInfo() {
		return riskEarlyWarn;
	}
}
