package com.xxx.system;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	@MonitorLogForService()
	public void doSth(){
		System.out.println("do sth ...");
	}
	
	@MonitorLogForService
	public void doSth(String str){
		System.out.println("do sth ..."+str);
	}

	public void doSth2(){
		System.out.println("do sth ...");
	}
	
}
