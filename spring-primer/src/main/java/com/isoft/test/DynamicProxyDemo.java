package com.isoft.test;

import com.isoft.proxy.LogProxy;
import com.isoft.service.IAService;
import com.isoft.service.IBService;
import com.isoft.service.imp.AServiceImpl;
import com.isoft.service.imp.BServiceImpl;

public class DynamicProxyDemo {
	public static void main(String[] args) {
		LogProxy logProxy=new LogProxy();
		
		IAService iAService=(IAService) logProxy.bind(new AServiceImpl());
		iAService.doSth();
		
		IBService iBservice=(IBService) logProxy.bind(new BServiceImpl());
		iBservice.doSth("sdfdsf");
		
		System.err.println(iAService.getClass()); //class com.sun.proxy.$Proxy0
		
		
		System.out.println("------------------------");
		//以下调用方法会出错
		//com.sun.proxy.$Proxy0 cannot be cast to com.isoft.service.imp.AServiceImpl
		AServiceImpl aa=(AServiceImpl) logProxy.bind(new AServiceImpl());
		aa.doSth();

		
		
	}
	

}
