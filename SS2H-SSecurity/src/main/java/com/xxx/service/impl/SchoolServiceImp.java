package com.xxx.service.impl;

import org.springframework.stereotype.Service;

import com.xxx.system.MonitorLogForService;

@Service
public class SchoolServiceImp {

	@MonitorLogForService  
	public void saySth(String str){
		System.out.println("China "+str);
	}
}
