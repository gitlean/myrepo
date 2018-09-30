package com.isoft.thsa;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Entity entity=new Entity(0);
		OperatorEntity op=new OperatorEntity(entity);
		
		final int THREAD_NUM = 50;
		Thread threads[] = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i++) {
			threads[i] = new Thread(op, "Thread" + i);
			threads[i].start();
		}
		
		Thread.sleep(20000);
		System.out.println(entity.getNum());

	}

}
