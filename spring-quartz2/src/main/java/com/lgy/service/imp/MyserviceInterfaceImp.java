package com.lgy.service.imp;

import org.springframework.stereotype.Service;

import com.lgy.service.MyserviceInterface;

@Service("myserviceInterface")
public class MyserviceInterfaceImp implements MyserviceInterface {

	public int fun(int a) {
		// TODO Auto-generated method stub
		return (a + 1);
	}

}
