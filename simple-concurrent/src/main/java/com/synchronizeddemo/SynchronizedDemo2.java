package com.synchronizeddemo;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * @author anonymous
 * @createTime 2020年10月22日 下午7:07:24
 * @describe https://www.cnblogs.com/huansky/p/8869888.html
 */
public class SynchronizedDemo2 {

	public static void main(String[] args) {
		
		
		Object lock = new Object();  //这样也能实现类锁的效果
		
		AAthread2 ath = new AAthread2(lock);
		Thread F_thread1 = new Thread(new AAthread2(lock), "thread1");
		Thread F_thread2 = new Thread(new AAthread2(lock), "thread2");
		Thread F_thread3 = new Thread(ath, "thread3");
		Thread F_thread4 = new Thread(ath, "thread4");

		F_thread1.start();
		F_thread2.start();
		F_thread3.start();
		F_thread4.start();

	}

}

class AAthread2 implements Runnable {

 
	private Object lock ;  

	public AAthread2(Object lock) {
		this.lock=lock;
	}
	
	private void dosth() {

		synchronized (lock) {

			System.out.println(
					Thread.currentThread().getName() + "\t" + new SimpleDateFormat("HH:mm:ss").format(new Date()));

			System.out.println(Thread.currentThread().getName() + "\t start" + "\t"
					+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "\t end" + "\t"
					+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
		}

	}

	@Override
	public void run() {
		dosth();

	}
}
