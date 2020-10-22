package com.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anonymous
 * @createTime 2020年10月22日 上午10:39:39
 * @describe 基于ReentrantLockDemo改动
 * 
 * lock.lock();
 */
public class ReentrantLockDemo1 {
	
 
	public static void main(String[] args) {
		 Lock lock = new ReentrantLock(); 
		 ArrayList<Integer> arrayList = new ArrayList<Integer>();
		 
//		 Thread th1=new Thread(new Athread(arrayList,lock),"thread-1");
//		 Thread th2=new Thread(new Athread(arrayList,lock),"thread-2");
//		 th1.start();
//		 th2.start();

		 for(int i=1;i<=10;i++) {
			 new Thread(new Athread(arrayList,lock),"thread-"+i).start();
		 }
	 
	}


}


class Athread implements Runnable{
	private ArrayList<Integer> arrayList ;
	
	private  Lock lock ; 
	
	public Athread(ArrayList<Integer> arrayList, Lock lock) {
		this.arrayList=arrayList;
		this.lock=lock;
	}
	

	@Override
	public void run() {
		
		insert();
	}
	
	private void insert() {
		
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "得到了锁");
			for (int i = 0; i < 5; i++) {
				arrayList.add(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println(Thread.currentThread().getName() + "释放了锁");
			lock.unlock();
		}
	}
	
	
}
