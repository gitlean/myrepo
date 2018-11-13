package com.isoft.spring.utils;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.isoft.spring.aop.AopConfig;
import com.isoft.spring.aop.service.IAddition;
import com.isoft.spring.aop.service.IEmployeeService;
import com.isoft.spring.aop.service.MyComponent;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfig.class)
public class AopUtilsTest extends TestCase {
	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private MyComponent component;

	@Test
	public void testIsAop() {
		assertTrue(AopUtils.isAopProxy(service));
	}

	@Test
	public void testIsJdk() {
		assertTrue(AopUtils.isJdkDynamicProxy(service));
	}

	@Test
	public void testIsCglibProxy() {
		System.out.println(AopUtils.isCglibProxy(service));
		System.out.println(AopUtils.isCglibProxy(component));
	}

	
	/**
	 *  class com.isoft.spring.aop.service.MyComponent$$EnhancerBySpringCGLIB$$54bd1e49
		class com.isoft.spring.aop.service.MyComponent
		
		很好理解，因为MyComponent是没有接口的，所以使用cglib完成代理，那么component的类型肯定是代理之后的类型，那我们要想得到真实类型，使用getTargetClass方法完成。
	 */
	@Test
	public void testTargetClass() {
		System.out.println(service.getClass());
		System.out.println(AopUtils.getTargetClass(service));
		
		System.out.println(component.getClass());
		System.out.println(AopUtils.getTargetClass(component));

	}
	
	//******************************************************************
	//	boolean isEqualsMethod(Method method)
	//	boolean isHashCodeMethod(Method method)
	//	boolean isToStringMethod(Method method)
	//	boolean isFinalizeMethod(Method method)
	//
	//	这四个方法很简单，用于判定给定的方法是否是equals方法，hashCode方法，toString方法或者finalize方法。因为在动态代理的时候，都是针对类级别的代理，加入匹配的切入点是 .(..)，那么是否是该类所有方法都会被代理？但是Object本身的equals,hashCode,toString,finalize方法，都是需要剔除在代理方法之外的，这四个方法就是来辅助做判断的。如果有兴趣的童鞋可以看一下JdkDynamicAopProxy类中的invoke方法中的相关实现；
	//******************************************************************
	
	
	
	
	
	@Test
    public void testMostSpecificMethod() throws Exception{
        Method m=component.getClass().getMethod("someLogic");
        System.out.println(m);
        Method om=AopUtils.getMostSpecificMethod(m, 
                 AopUtils.getTargetClass(component));
        System.out.println(om);
    }

	//******************************************************************
	
	//	boolean canApply(Pointcut pc, Class<?> targetClass)：判断一个切入点能否匹配一个指定的类型；
	//	boolean canApply(Pointcut pc, Class<?> targetClass, boolean hasIntroductions)：判断一个切入点能否匹配一个指定的类型，是否支持引入匹配；
	
	//	boolean canApply(Advisor advisor, Class<?> targetClass)：判断一个建议(advisor)能否匹配一个指定的类型；
	//	boolean canApply(Advisor advisor, Class<?> targetClass, boolean hasIntroductions)：判断一个建议(advisor)能否匹配一个指定的类型，是否支持引入匹配；
	//
	//	List<Advisor> findAdvisorsThatCanApply(List<Advisor> candidateAdvisors, Class<?> clazz)：在一组建议(advisor)中，返回能够匹配指定类型的建议者列表；
	//
	//	这两组方法也算AOP核心方法了，用于判断一个切入点是否匹配一个类型；
	//******************************************************************
	@Test
	public void testApply(){
	    AspectJExpressionPointcut pc=new AspectJExpressionPointcut(); //Pointcut
	    pc.setExpression("execution(* com.isoft.spring.aop.service.MyComponent.*(..))");
	    assertTrue(AopUtils.canApply(pc, MyComponent.class));
	    assertFalse(AopUtils.canApply(pc, IEmployeeService.class));
	}

	
	//我们的目标是，在不修改IEmployeeService的前提下，为EmployeeServiceImpl额外添加IAddition接口，并使用AdditionImpl作为其实现。意思就是，当我得到EmployeeServiceImpl对象的时候，我可以强转为IAddition接口，并执行additional方法，打印出"out additional..."；
	//	要实现这个需求非常方便，只需要在Advice中添加：
	//	@DeclareParents(value = "cn.wolfcode.springboot.utilstest.IEmployeeService+", defaultImpl = AdditionImpl.class)
	//	public IAddition addition;

	@Test
	public void testIntroductions(){
		((IAddition)service).addtional();
	}
	
	
	//	Object invokeJoinpointUsingReflection(Object target, Method method, Object[] args)
	//	执行一个目标方法；这个方法其实就是method.invoke方法的更完善的方法，指在target对象上，使用args参数列表执行method；

	@Test
	public void testInvokeJoinpointUsingReflection(){
		Method m;
		try {
			System.out.println("testInvokeJoinpointUsingReflection");
			m = component.getClass().getMethod("someLogic");
			AopUtils.invokeJoinpointUsingReflection(component,m,null);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
