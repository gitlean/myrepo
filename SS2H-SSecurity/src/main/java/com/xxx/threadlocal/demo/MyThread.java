package com.xxx.threadlocal.demo;

public class MyThread implements Runnable {
	Data data;
	//public MyThread(){}
	public MyThread(Data data){
		this.data=data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		data.getLonglocal().set(Thread.currentThread().getId());
		data.getStringlocal().set(Thread.currentThread().getName());
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("当前线程ID："+Thread.currentThread().getId()+"\t获取longLocal get():\t"+data.getLonglocal().get());
		System.out.println("当前线程Name："+Thread.currentThread().getName()+"\t获取stringLocal get():\t"+data.getStringlocal().get());
		

	}

}
