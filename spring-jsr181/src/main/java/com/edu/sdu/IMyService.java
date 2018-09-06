/**
 * 
 */
package com.edu.sdu;

import java.util.List;

import javax.jws.WebParam; //如不导入此包    add(@WebParam(name="a")int a, int b)错误提示;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author john
 * 
 */
@WebService
public interface IMyService {
	/**
	 * @WebResult(name="addResult") 此注解可加可不加，如果加了但不指定name属性的值跟没加是一样的，
	 *                              加上name的效果就是在wsdl文件的定义中将该方法的返回值的名称固定了，
	 *                              而不是【方法名Response
	 *                              】,例如add方法的返回参数的定义将为：addResponse
	 * 
	 * @WebParam(name="a") 此注解是将方法的参数的名称用一个有意义的名称进行定义,
	 *                     如果不定义那wsdl中将是arg0、arg1....这种无意义的名称
	 * @param a
	 * @param b
	 * @return
	 * 
	 */
	@WebResult(name = "addResult")
	public int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

	@WebResult(name = "loginResult")
	public boolean login(@WebParam(name = "username") String username, @WebParam(name = "password") String password);

	@WebResult(name = "user")
	public User getUserByUsername(@WebParam(name = "username") String username);

	/**
	 * 这里将WebResult和WebParam定义为user是为了使用jaxb进行类的编排和反编排时方便
	 */
	@WebResult(name = "user")
	public List<User> getChildListByUser(@WebParam(name = "user") User user);

	@WebResult(name = "deleteResult")
	public boolean deleteUser(@WebParam(header = true, name = "adminName") String adminName,
			@WebParam(name = "deleteName") String delName);

	@WebResult(name = "testExceptionResult")
	public void testException() throws MyException;
}
