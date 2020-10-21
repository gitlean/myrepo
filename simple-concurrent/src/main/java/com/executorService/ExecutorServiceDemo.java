package com.executorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * http://blog.csdn.net/defonds/article/details/44021605/
 * @author john
 * 
 * http://blog.csdn.net/yuzhiboyi/article/details/7775266       important
 * ExecutorService实际上是一个线程池的管理工具
 *
 */
public class ExecutorServiceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		call3();

	}
	
	static void call1(){
	    ExecutorService executorService = Executors.newSingleThreadExecutor();  
	      
	    executorService.execute(new Runnable() {  
	        public void run() {  
	            System.out.println("Asynchronous task");  
	        }  
	    });  
	      
	    executorService.shutdown();  

	}
	
	
	static void call2(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();  
		
		Future future = executorService.submit(new Runnable() {  
		    public void run() {  
		        System.out.println("Asynchronous task");  
		    }  
		});  
		  
		try {
			//future.get();
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //returns null if the task has finished correctly. 
		
		executorService.shutdown(); 
	}

	
	static void call3(){
	    ExecutorService executorService = Executors.newFixedThreadPool(10);  
	      
	    executorService.execute(new Runnable() {  
	        public void run() {  
	            System.out.println("Asynchronous task");  
	        }  
	    });  
	      
	    executorService.shutdown();  
	}
}
