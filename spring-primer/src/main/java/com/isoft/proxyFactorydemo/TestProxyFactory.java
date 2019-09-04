package com.isoft.proxyFactorydemo;

import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;
/**
 * 
 * @author john
 * @date 2018年11月17日
 * @time 上午10:32:02
 * 
 * 
 * https://blog.csdn.net/u012834750/article/details/71773598
 * @describe:从运行结果来看，配置多个通知时，前置通知正序执行，后置通知逆序执行，环绕通知前正、后逆。MethodInterceptor：方法拦截器可以实现MethodBeforeAdvice接口、AfterReturningAdvice接口、ThrowsAdvice三个接口所能够实现的效果。
 * 
 * 注：BeanPostProcessor、ProxyFactory、MethodInterceptor可用来实现动态数据源。
 * 
 * 思考：ProxyFactory这种实现切面通知的方式与手写AOP最大的区别？
 * AOP有切入点表达式，能方便指定在哪个切点上执行通知，ProxyFactory这种方式需手动设置目标对象。ProxyFactory是基于Cglib实现的。
 */
public class TestProxyFactory {

    @Test
    public void test(){
        //代理对象需要的实现的接口
        final Class[] interfaces=new Class[]{Person.class};   //final关键字

        //利用spring的API,创建接口代理工厂
        ProxyFactory proxyFactory=new ProxyFactory(interfaces);

        //设置目标对象（可以是Object）
        proxyFactory.setTarget(new Man());
        
        
        
        

        //添加方法前置通知
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target)
                    throws Throwable {
                System.out.println("在吃饭方法调用之前拦截:吃饭前要洗手");
            }
        });
        //可以添加多个方法前置或者后置通知
        proxyFactory.addAdvice(new MethodBeforeAdvice() {

            @Override
            public void before(Method method, Object[] args, Object target)
                    throws Throwable {
                System.out.println("在吃饭方法调用之前拦截-2：要等长辈先吃");
            }
        });
        //可以添加多个方法前置或者后置通知
        proxyFactory.addAdvice(new AfterReturningAdvice() {

            @Override
            public void afterReturning(Object returnValue, Method method,
                                       Object[] args, Object target) throws Throwable {
                System.out.println("吃饭方法完成之后调用：饭后要洗碗");

            }
        });

        //可以添加多个方法前置或者后置通知
        proxyFactory.addAdvice(new AfterReturningAdvice() {

            @Override
            public void afterReturning(Object returnValue, Method method,
                                       Object[] args, Object target) throws Throwable {
                System.out.println("吃饭方法完成之后调用2：饭后散下步");

            }
        });


        //对于环绕通知只能添加一个,多添加也是没有用的，spring会选第一个advice，请看结果

        proxyFactory.addAdvice(new MethodInterceptor() {

            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {

                Object aThis = invocation.getThis();
                System.out.println("方法环绕调用前："+aThis);

                Object proceed = invocation.proceed();//执行被代理对象的方法,返回方法的返回值

                System.out.println("方法环绕调用后："+proceed.toString());

                return proceed;
            }
        });

        //对于环绕通知只能添加一个,多添加也是没有用的，spring会选第一个advice，请看结果
        proxyFactory.addAdvice(new MethodInterceptor() {

            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {

                Object aThis = invocation.getThis();
                System.out.println("方法环绕调用前2："+aThis);

                Object proceed = invocation.proceed();//执行被代理对象的方法,返回方法的返回值

                System.out.println("方法环绕调用后2："+proceed.toString());

                return proceed;
            }
        });

        Person person = (Person) proxyFactory.getProxy(); //通过代理拿到的
        person.eat("龙虾");


    }
}
 
