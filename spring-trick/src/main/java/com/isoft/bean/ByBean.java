package com.isoft.bean;

import org.springframework.stereotype.Component;

/**
*@author anonymous
*@createTime 2020年11月4日 下午10:26:45
*@describe
*/
@Component("byBean")
public class ByBean implements ISaySth {

	@Override
	public void saySth() {
		System.out.println("ByBean");

	}

}
