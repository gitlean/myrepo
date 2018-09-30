package com.concurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://www.cnblogs.com/starcrm/p/4998067.html
 * 
 * 运行程序，会有         consumerN Consumer null   这种情况        （理解阻塞和非阻塞）
 * @author john
 *
 */
public class NoBlockQueue {  
       private static ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();   
          
    public static void main(String[] args) {  
        ExecutorService executorService = Executors.newFixedThreadPool(2);  

        executorService.submit(new Producer("producer1"));  
        executorService.submit(new Producer("producer2"));  
        executorService.submit(new Producer("producer3")); 
        
        executorService.submit(new Consumer("consumer1"));  
        executorService.submit(new Consumer("consumer2"));  
        executorService.submit(new Consumer("consumer3"));  
        executorService.shutdown();

    }  
  
    static class Producer implements Runnable {  
        private String name;  
  
        public Producer(String name) {  
            this.name = name;  
        }  
  
        public void run() {  
            for (int i = 1; i < 10; ++i) {  
                System.out.println(name+ " start producer " + i);  
                concurrentLinkedQueue.add(i);  
               
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //System.out.println(name+"end producer " + i);  
            }  
        }  
    }  
  
    static class Consumer implements Runnable {  
        private String name;  
  
        public Consumer(String name) {  
            this.name = name;  
        }  
        public void run() {  
            for (int i = 1; i < 10; ++i) {  
                try {
 
                    System.out.println(name+" Consumer " +  concurrentLinkedQueue.poll());
                   
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }  
//                System.out.println();  
//                System.out.println(name+" end Consumer " + i);  
            }  
        }  
    }  
}