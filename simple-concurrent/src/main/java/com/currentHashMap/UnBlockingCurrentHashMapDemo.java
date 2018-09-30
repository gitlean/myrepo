package com.currentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 非阻塞ConcurrentHashMap的示例  (或许阻塞、非阻塞只针对队列)   线程安全非阻塞队列有ConcurrentLinkedQueue
 * @author john
 *
 */
public class UnBlockingCurrentHashMapDemo {
	
	
	public static void main(String[] args) {
		//创建一个线程池管理器
		ExecutorService executeService=Executors.newFixedThreadPool(10);
		
		ConcurrentHashMap<Integer,String> chm=new ConcurrentHashMap<Integer,String>();
//		chm.put(8, "aaa");
//		chm.remove(8);
//		System.out.println(chm.get(8));
		
		for(int j=0;j<3;j++){
			executeService.submit(new Consumer("consumer"+j,chm));
		}
		
		//禁止添加新任务
		executeService.shutdown();
		
	}
	

	

}

class Producer implements Runnable{
	String name;
	ConcurrentHashMap<Integer,String> chm;
	public Producer(String name,ConcurrentHashMap<Integer,String> chm){
		this.name=name;
		this.chm=chm;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class Consumer implements Runnable{
	String name;
	ConcurrentHashMap<Integer,String> chm;
	public Consumer(String name,ConcurrentHashMap<Integer,String> chm){
		this.name=name;
		this.chm=chm;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" call "+this.name+"...");
		
		chm.remove(5);
		
		//or
		
		//System.out.println(chm.get(5));
		//chm.get(5);
		
		System.out.println(Thread.currentThread().getName()+"--->"+this.name+" has done!");
	}
	
}