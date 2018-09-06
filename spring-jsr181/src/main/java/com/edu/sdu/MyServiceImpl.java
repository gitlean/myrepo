package com.edu.sdu;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.jws.HandlerChain;
//代码说明:MyServiceImpl类的所有非静态公开方法将对外部暴露. 
//这里指定服务的接口类的路径

@WebService(endpointInterface = "com.edu.sdu.IMyService")
@HandlerChain(file = "service-handler-chain.xml") // 添加Handler配置文件
public class MyServiceImpl implements IMyService {

	@Override
	public int add(int a, int b) {
		System.out.println("a+b=" + (a + b));
		return a + b;
	}

	@Override
	public boolean login(String username, String password) {
		if ("test".equals(username) && "123456".equals(password)) {
			System.out.println(username + ":login success!!");
			return true;
		}
		System.out.println(username + ":login failure!!");
		return false;
	}

	@Override
	@WebResult(name = "user")
	public User getUserByUsername(@WebParam(name = "username") String username) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		return user;
	}

	@Override
	@WebResult(name = "user")
	public List<User> getChildListByUser(@WebParam(name = "user") User user) {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList<User>();
		result.add(new User("张三", "11111"));
		result.add(new User("李四", "22222"));
		return result;
	}

	@Override
	@WebResult(name = "deleteResult")
	public boolean deleteUser(@WebParam(header = true, name = "adminName") String adminName,
			@WebParam(name = "deleteName") String delName) {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	@WebResult(name = "testExceptionResult")
	public void testException() throws MyException {
		// TODO Auto-generated method stub
		throw new MyException("this is my exception");

	}

}
