package com.edu.sdu;

import javax.xml.ws.Endpoint;
/**
 * @WebService
 * 
 * */
public class RunService {
	
	   public static void main(String[] args) {
	        String url = "http://localhost:8888/ws01";
	        Endpoint endPoint1=Endpoint.publish(url, new MyServiceImpl());
	        
	        System.out.println("webService is running...");
	        
	        
/*	        try {
	        	//Thread.sleep(10 * 1000);
				Thread.sleep(1 * 60 * 1000);  //Thread.Sleep()�������ڽ���ǰ�߳�����һ��ʱ�� ʱ�䵥λ�Ǻ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        System.out.println("Server exiting");  
	        System.exit(0); */
	    }

}
