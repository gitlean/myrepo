package com.isoft.interfacemethod.demo;

import com.isoft.interfacemethod.Calculator;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//现在，用户会被迫面向Calculator接口进行编程，而且他们不能够知道该接口具体的实现细节。
		Calculator ins=Calculator.getInstance();
		System.out.println(ins.add(4, 5));
		
		
		
		System.out.println(ins.remainder(34, 5));
		
		
		
		
	}

}
