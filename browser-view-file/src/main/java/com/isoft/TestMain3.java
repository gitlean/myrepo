package com.isoft;

import com.isoft.threads.MyThread;

public class TestMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------");
		for(int i=0;i<10;i++){
			MyThread mt=new MyThread();
			Thread t=new Thread(mt);
			t.start();
		}

	}

}
