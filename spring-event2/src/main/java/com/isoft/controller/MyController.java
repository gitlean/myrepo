package com.isoft.controller;

import org.springframework.stereotype.Component;

import com.isoft.entity.RiskEarlyWarn;

/**
*@author anonymous
*@createTime 2020年11月5日 下午6:57:08
*@describe 
*/

//这里模仿  mvc controller
@Component("myController")
public class MyController {
	

	//dobusiness，aop配置
	public String aMethod(RiskEarlyWarn riskEarlyWarn) {
		
		return "Hello World";
	}

}
