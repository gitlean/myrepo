package com.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * http://blog.csdn.net/yuzhiboyi/article/details/7775266
* Created by IntelliJ IDEA.
*
* @author leizhimin 2008-11-25 14:28:59
*/
public class TestCachedThreadPool {
        public static void main(String[] args) {
        		//ExecutorService executorService = Executors.newCachedThreadPool();
                ExecutorService executorService = Executors.newFixedThreadPool(5);       //更改参数 小于5  大于5   运行看结果
                //ExecutorService executorService = Executors.newSingleThreadExecutor();

                for (int i = 0; i < 5; i++) {
                        executorService.execute(new TestRunnable());
                        System.out.println("************* a" + i + " *************");
                }
                executorService.shutdown();
        }
}

class TestRunnable implements Runnable {
        public void run() {
                System.out.println(Thread.currentThread().getName() + "线程被调用了。");
               
                
                while (true) {
                        try {
                                Thread.sleep(5000);
                                System.out.println(Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
      
        }
}
