package com.isoft.interrupt;

/**
 * @author anonymous
 * @createTime 2020年11月20日 上午9:56:08
 * @describe
 */
public class InterruptDemo {

	public static void main(String[] args) {
		new Thread(new InterrutThread()).start();

	}

}

class InterrutThread implements Runnable {

	@Override
	public void run() {


		//如果线程的interrupt方法先被调用，然后线程调用阻塞方法进入阻塞状态，InterruptedException异常依旧会抛出。
		Thread.currentThread().interrupt();
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().isInterrupted());
		
		
		//如果线程捕获InterruptedException异常后，继续调用阻塞方法，将不再触发InterruptedException异常。
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("over");
		
		
	}

}
