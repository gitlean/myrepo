package com.xxx.threadlocal.demo;

public class Data {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	public  ThreadLocal<Long> getLonglocal() {
		return longLocal;
	}
	public  ThreadLocal<String> getStringlocal() {
		return stringLocal;
	}

}
