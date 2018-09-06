package com.isoft;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyLock {

	private AtomicBoolean locked = new AtomicBoolean(false);

	public boolean lock() {

		//它使用一个期望值和AtomicBoolean实例的值比较，和两者相等，则使用一个新值替换原来的值。
		//在这个例子中，它比较locked的值和false，如果locked的值为false，则把修改为true。
		return locked.compareAndSet(false, true);
		
		//使用Java5+提供的CAS特性而不是使用自己实现的的好处是Java5+中内置的CAS特性可以让你利用底层的你的程序所运行机器的CPU的CAS特性。
		//这会使还有CAS的代码运行更快。

	}
	
	public static void main(String[] args) {
		MyLock ll=new MyLock();
		boolean flag=ll.lock();
		System.out.println(flag);
	}

}