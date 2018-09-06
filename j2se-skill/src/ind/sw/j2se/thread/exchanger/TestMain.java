package ind.sw.j2se.thread.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class TestMain {
	public static void main(String[] args) {
		Exchanger<List<Integer>> exchanger = new Exchanger<>();
		new Consumer(exchanger).start();
		new Producer(exchanger).start();
	}
}
