package com.isoft.threads;

public class MyThread implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
			System.out.println(Thread.currentThread().getName()+"----->"+i);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
