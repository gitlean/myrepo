package ind.sw.j2se.thread.volatilelearn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author john
 * @date   2017年12月15日
 * @time   下午3:04:52
 * @description 采用AtomicInteger：
 */
public class Test4 {
	public AtomicInteger inc = new AtomicInteger();

	public void increase() {
		inc.getAndIncrement();
	}

	public static void main(String[] args) {
		final Test4 test = new Test4();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();
		System.out.println(test.inc);
	}
}
