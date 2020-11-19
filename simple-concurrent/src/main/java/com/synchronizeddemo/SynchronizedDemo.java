package com.synchronizeddemo;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * @author anonymous
 * @createTime 2020年10月22日 下午7:07:24
 * @describe https://www.cnblogs.com/huansky/p/8869888.html
 */
public class SynchronizedDemo {

	public static void main(String[] args) {
		AAthread ath = new AAthread();
		Thread F_thread1 = new Thread(new AAthread(), "thread1");
		Thread F_thread2 = new Thread(new AAthread(), "thread2");
		Thread F_thread3 = new Thread(ath, "thread3");
		Thread F_thread4 = new Thread(ath, "thread4");

		F_thread1.start();
		F_thread2.start();
		F_thread3.start();
		F_thread4.start();

	}

}

class AAthread implements Runnable {

	// static Object lock =new Object(); //如果是static修饰，就是类锁
	// 相当于synchronized(AAthread.class)
	 Object lock = new Object(); // 对象锁 相当于synchronized(this)

	//还可以修饰方法 dosth() ，对象锁，因为是非静态方法；如果是静态方法则是类锁
	
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
