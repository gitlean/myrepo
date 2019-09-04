package com.isoft.proxyFactorydemo2;

public class EnglishService implements PeopleService {

	@Override
	public void sayHello() {
		System.err.println("Hi~");
	}

	@Override
	public void printName(String name) {
		System.err.println("Your name:" + name);
	}

}
