package com.isoft.threads;

import java.util.Map;

public class MyThread implements Runnable {
	static Object lock = new Object();
	private Map<String, Integer> map = null;

	public static int countn = 0;

	public MyThread() {

	}

	public MyThread(Map<String, Integer> map) {
		this.map = map;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stu
//		synchronized (lock) {
//			countn++;
//		}
		countn++;
		int num = map.get("param");
		int temp = num;
		num++;
		map.put("param", num);
		System.out.println(temp + "-------------->" + num + "------------->" + countn);

	}

}
