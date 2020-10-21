package com.threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author anonymous
 * @createTime 2020年10月21日 下午6:31:47
 * @describe  https://www.cnblogs.com/jiawen010/p/11855768.html
 * 			  https://blog.csdn.net/u013738122/article/details/88595505
 * 
 * 自定义线程池（ThreadPoolExecutor和BlockingQueue连用）：

     自定义线程池，可以用ThreadPoolExecutor类创建，它有多个构造方法来创建线程池。

     常见的构造函数：ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
 *
 *keepAliveTime：如果一个线程处在空闲状态的时间超过了该属性值，就会因为超时而退出。举个例子，如果线程池的核心大小corePoolSize=5，而当前大小poolSize =8，那么超出核心大小的线程，会按照keepAliveTime的值判断是否会超时退出。如果线程池的核心大小corePoolSize=5，而当前大小poolSize =5，那么线程池中所有线程都是核心线程，这个时候线程是否会退出，取决于allowCoreThreadTimeOut。
 *
 *
 */

public class ZiDingYiThreadPoolExecutor {

	public static class TempThread implements Runnable {  //静态内部类   https://www.cnblogs.com/Dean-0/p/11198112.html Java中静态类只有一种，那就是静态内部类

		@Override
		public void run() {
			// 打印正在执行的缓存线程信息
			System.out.println(Thread.currentThread().getName() + "正在被执行");
			try {
				// sleep一秒保证3个任务在分别在3个线程上执行
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// 创建数组型缓冲等待队列
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
		// ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, bq);

		// 创建3个任务
		Runnable t1 = new TempThread();
		Runnable t2 = new TempThread();
		Runnable t3 = new TempThread();
		Runnable t4 = new TempThread();
		Runnable t5 = new TempThread();
		Runnable t6 = new TempThread();

		// 3个任务在分别在3个线程上执行
		tpe.execute(t1);
		tpe.execute(t2);
		tpe.execute(t3);
		tpe.execute(t4);
		tpe.execute(t5);
		tpe.execute(t6);

		// 关闭自定义线程池
		tpe.shutdown();
	}

}
