package com.isoft.interfacemethod;

public interface Calculator {
	static Calculator getInstance() {
		return new BasicCalculator();
	}

	int add(int first, int second);

	int subtract(int first, int second);

	int divide(int number, int divisor);

	int multiply(int first, int second);
	
	
	//实现了该接口的类不需要给这些方法提供实现。如果一个实现类为这些方法提供了实现，那么新给出的实现将会被使用，否则接口中的默认实现将被使用。
	default int remainder(int number, int divisor) {
	    return subtract(number, multiply(divisor, divide(number, divisor)));
	}
	
	
}
