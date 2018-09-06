package ind.sw.j2se.thread.volatilelearn;

/**
 * volatile不支持原子性
 * @author john
 * @date   2017年12月15日
 * @time   下午2:55:22
 * @description
 */

//10*1000=10000
public class Test {
	public volatile int inc = 0;

	public void increase() {
		inc++;
	}

	public static void main(String[] args) {
		final Test test = new Test();
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
