package com.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anonymous
 * @createTime 2020年10月22日 上午10:39:39
 * @describe https://www.cnblogs.com/dolphin0520/p/3923167.html
 * 
 * lock.lock();
 */
public class ReentrantLockDemo {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private  Lock lock = new ReentrantLock(); // 注意这个地方
	public static void main(String[] args) {
		final ReentrantLockDemo test = new ReentrantLockDemo();

		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				test.insert(Thread.currentThread());
			};
		}.start();
	}

	public void insert(Thread thread) {
		
		lock.lock();
		try {
			System.out.println(thread.getName() + "得到了锁");
			for (int i = 0; i < 5; i++) {
				arrayList.add(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println(thread.getName() + "释放了锁");
			lock.unlock();
		}
	}
}
