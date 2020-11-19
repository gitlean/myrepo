package com.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 参考
 *    /CountDownLatchDemo/src/com/semaphore/p1/SemaphoreTest.java
 *    /CountDownLatchDemo/src/com/semaphore/p1/SemaphoreTestB.java
 * @author john
 *	  http://blog.csdn.net/sinat_36246371/article/details/53872412
 */
public class SemaphoreTest {
	final static int SEMP_COUNT=5;
    public static void main(String[] args) {  
       
    	
       // 线程池 
       ExecutorService exec = Executors.newCachedThreadPool();  
       // 只能5个线程同时访问 
       final Semaphore semp = new Semaphore(SEMP_COUNT);  
       // 模拟20个客户端访问 
       for (int index = 0; index < 20; index++) {
           //final int NO = index;  
           Runnable run = new Runnable() {  
               public void run() {  
                   try {  
                       // 获取许可 
                	   atomicOP(semp);
                	   
                	   //do something...
                	  
                	  
                       Thread.sleep((long) (Math.random() * 10000));  
                       
                       
                       //atomicOP2(semp);    //为什么这样写 会不对????????
                       semp.release();
                   } catch (InterruptedException e) {  
                	   e.printStackTrace();
                   }finally{
                	   //最好将release放到finally中，不然线程终端后 信号量是不会释放的
                	   //semp.release();
                   }
               }  
           };  
           exec.execute(run);  
       }  
       // 退出线程池 
       exec.shutdown();  
   }  
    
   
    /**
     * 原子操作
     * @param semp
     * @throws InterruptedException
     */
   public synchronized static void atomicOP(Semaphore semp) throws InterruptedException{
	   //从此信号量获取一个许可
	   semp.acquire();  
	   System.out.println("线程" + Thread.currentThread().getName() + 
               "进入，当前已有" + (SEMP_COUNT-semp.availablePermits()) + "个并发");
	   
   }
    
   public synchronized static void atomicOP2(Semaphore semp) throws InterruptedException{
	   System.out.println("线程" + Thread.currentThread().getName() + 
               "即将离开");                    
	   semp.release();//释放许可，许可数加1
       
       System.out.println("线程" + Thread.currentThread().getName() + 
               "已离开，当前已有" + (SEMP_COUNT-semp.availablePermits()) + "个并发");   
	   
   }
    
}
