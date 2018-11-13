package com.isoft.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.isoft.spring.aop.service.IEmployeeService;
import com.isoft.spring.aop.service.imp.EmployeeServiceImpl;

/**
 *  注意：
	1，@Configuration代表这是Spring的java配置类；
	2，@ComponentScan代表自动扫描组件，所以Advice类会自动加载；
	3，@EnableAspectJAutoProxy，如果要使用annotation的方式完成AOP，必须要在主配置类上添加这个标签，相当于XML中配置的
	<aop:aspectj-autoproxy/>
	4，提供被代理的目标对象，EmployeeServiceImpl；
 * @author john
 * @date 2018年10月18日
 * @time 下午5:27:02
 * @describe:
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public IEmployeeService target() {
        return new EmployeeServiceImpl();
    }

}

