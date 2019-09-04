package com.xxx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.system.MonitorLogForService;
import com.xxx.system.MyService;

@Service
public class SchoolServiceImp {
	 
	@MonitorLogForService  
	public void saySth(String str){
		System.out.println("China "+str);
		 
	}
	
 
	
}
