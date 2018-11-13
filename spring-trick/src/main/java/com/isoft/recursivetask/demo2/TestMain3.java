package com.isoft.recursivetask.demo2;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;


public class TestMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		call();
	}
	
	//并行流 与 顺序流
	public static void call() {
		Instant start = Instant.now();
		long data1=LongStream.rangeClosed(0, 110)
				// 并行流
				.parallel().reduce(0, Long::sum);

		long data2=LongStream.rangeClosed(0, 110)
				// 顺序流
				.sequential().reduce(0, Long::sum);

		System.out.println(data1);
		System.out.println(data2);
		Instant end = Instant.now();
		System.out.println("耗费时间" + Duration.between(start, end).toMillis());
		
	
	}


}
