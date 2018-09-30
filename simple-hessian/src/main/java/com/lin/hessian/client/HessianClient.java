package com.lin.hessian.client;
import java.net.MalformedURLException;
import com.caucho.hessian.client.HessianProxyFactory;
import com.liny.hessian.service.Basic;
/**
 * 注意：这里笔者故意将客户端与服务端的Basic接口的包路径定义成不一样（一个是com.liny.hessian.service，一个是com.lin.hessian.service），经过验证这样是可以的，但是推荐最好两者一模一样。
 * @author john
 * @date 2018年9月28日
 * @time 下午5:39:59
 * @describe:
 */
public class HessianClient {
    public static void main(String[] args) throws MalformedURLException{
    	String url = "http://localhost:8080/simple-hessian/hello";
    	//String url = "http://localhost:8080/simple-hessian/liny";
        HessianProxyFactory factory = new HessianProxyFactory();
        Basic basic = (Basic)factory.create(Basic.class, url);
        System.out.println(basic.sayHello());
    }
}