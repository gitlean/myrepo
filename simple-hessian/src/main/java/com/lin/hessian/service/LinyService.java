package com.lin.hessian.service;

import com.caucho.hessian.server.HessianServlet;

public class LinyService extends HessianServlet implements Basic {
	private String message = "wowwowowowowow";

	@Override
	public String sayHello() {
		return message;
	}
}