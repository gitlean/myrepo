package com.isoft.recursivetask;

import java.util.concurrent.ForkJoinPool;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//call1();
		//call2();
		
		//call3();
		call4();

	}
	
	public static void call1(){
		ATask aTask=new ATask();
		BTask bTask=new BTask();
		
		aTask.fork();
		bTask.fork();
		
		aTask.join();
		bTask.join();
		
		
		System.out.println(aTask.resultMap);
		System.out.println(bTask.resultMap);
		
	}
	
	
	public static void call2(){
		ATask aTask=new ATask();
		BTask bTask=new BTask();
		
		ForkJoinPool pool=new ForkJoinPool(10);
		pool.submit(aTask);
		pool.submit(bTask);
		
		
		System.out.println(aTask.resultMap);
		System.out.println(bTask.resultMap);
		
	}
	
	public static void call3(){
		CollectionTask collectTask=new CollectionTask();
		
		ForkJoinPool pool=new ForkJoinPool(10);
		pool.submit(collectTask);
		 
		System.out.println(collectTask.resultMap);
	
	}
	
	public static void call4(){
		CollectionTask collectTask=new CollectionTask();
		
		collectTask.fork();
		collectTask.join();
		 
		 
		System.out.println(collectTask.resultMap);
	
	}

}
