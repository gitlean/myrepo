package com.isoft.service.imp;

import com.isoft.service.ITimeBook;

public class TimeBook implements ITimeBook {

	public void doAuditing(String name) {
		
		System.out.println("doAuditing.........");
	}

	@Override
	public void call() {
		System.out.println("call.........");
		
	}

}
