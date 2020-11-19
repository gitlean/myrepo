package com.concurrentLinkedQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author anonymous
 * @createTime 2020年10月21日 下午10:37:24
 * @describe
 */
public class BlockAndUnBlockQueueDemo2 {

	private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.submit(new Producer("producer1"));

		executorService.submit(new Consumer("consumer1"));

		executorService.shutdown();

	}

	static class Producer implements Runnable {
		private String name;

		public Producer(String name) {
			this.name = name;
		}

		public void run() {
			for (int i = 1; i < 10; ++i) {
				System.out.println(name + " start producer " + i);
				queue.add(i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(name+"end producer " + i);
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

					System.out.println(name + " Consumer " + queue.take()); //注意，这里用了take

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//	                System.out.println();  
//	                System.out.println(name+" end Consumer " + i);  
			}
		}
	}

}
