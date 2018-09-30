package com.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//实例化一个线程池管理器
		 ExecutorService executorService = Executors.newFixedThreadPool(10);
		 //创建8个任务
		 for(int i=0;i<8;i++){
			executorService.submit(new MyThreadOne("Task"+i));
		 }
		 
		 executorService.shutdown();
		 
		 //当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,以后不能再往线程池中添加任何任务，否则将会抛出RejectedExecutionException异常。但是，此时线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出。
		 //executorService.submit(new MyThreadOne("Task"+9));
		 
		
		 
	}

}


class MyThreadOne implements Runnable{
	String name;
	public MyThreadOne(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" now call "+this.name);
		
		
		try {
			Thread.currentThread().sleep((long)(Math.random()*10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("任务："+this.name+" is doing...");
		
	}
	
}