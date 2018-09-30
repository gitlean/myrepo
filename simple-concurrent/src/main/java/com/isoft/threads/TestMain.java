package com.isoft.threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Map<String,Integer> map=new HashMap<String,Integer>();
//		Collections.synchronizedMap(map);
//		
		
//		Hashtable<String,Integer> map=new Hashtable<String,Integer>();

		Map<String,Integer> map=new ConcurrentHashMap<String,Integer>();
		
		MyThread.countn=0;
		map.put("param", 0);
		for(int i=0;i<100;i++){
			new Thread(new MyThread(map)).start();
		}
		
		try {
			Thread.currentThread().sleep(2000);//休眠10s 确保其他各个线程都运行完毕
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(map.get("param"));
		System.out.println(MyThread.countn);

	}

}
