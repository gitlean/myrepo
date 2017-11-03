package com.xxx.system;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xxx.system.entity.MonitorLog;
/**
 * Aspect类
 * @author john
 * @date   2017年10月27日
 * @description  创建切入代码
 */
@Component
@Aspect
public class MonitorLogAspect {
	private static Logger logger=LoggerFactory.getLogger(MonitorLogAspect.class);
	@Autowired
	private MonitorLogPublisher publisher;
	
	
	@Pointcut("@annotation(com.xxx.system.MonitorLogForService)")
	public void pointCut() {}//实际切入的代码

	@Before("pointCut()")
	public void beforeMethod(JoinPoint joinPoint)  {
		String key = joinPoint.getSignature().toString();
		logger.debug("Aspect before ..."+key);

//		Object[] args = joinPoint.getArgs();// 如果需要这里可以取出参数进行处理
//		for(int i=0;i<args.length;i++){
//			System.out.print(args[i]+"\t");
//		}
		
		
		
		String[] annotations=new String[3];
		String cName=joinPoint.getTarget().getClass().getName();
		String mName=joinPoint.getSignature().getName();
		
		Object[] arguments=joinPoint.getArgs();
		Method[] methods=new Method[]{};
		
		logger.debug("cName:"+cName);
		logger.debug("mName:"+mName);
		
		
		
		
		Class<?> targetClass = null;
		try {
			targetClass = Class.forName(cName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		methods=targetClass.getMethods(); //获取targetClass所有方法
		
		for(Method method:methods){
			//logger.debug(method.getName());
			if(method.getName().equals(mName)){ //与当前关注的方法名相同 
				Class[] clazzs=method.getParameterTypes();
				if(clazzs.length==arguments.length){//进一步判断参数(考虑多态)
					logger.debug(method.getName());

					//注意MonitorLogForService上的注解
					//@Documented
					//@Retention(RetentionPolicy.RUNTIME)
					
					MonitorLogForService mlogService=method.getAnnotation(MonitorLogForService.class);
					
					annotations[0]=mlogService.module();
					annotations[1]=mlogService.operation();
					annotations[2]=mlogService.type();
					
					logger.debug(mlogService.fg()+"");
					
					break;
				}
			}
		}//找到annotation上携带的参数
		
		
		logger.debug(annotations[0]+"\t"+annotations[1]+"\t"+annotations[2]);
		
		
		//下面可以将annotation上携带的参数入库----------用户在view上的一些操作
		
		
		MonitorLog log=new MonitorLog();
		//补充内容
		log.setModule(annotations[0]);
		log.setOperation(annotations[1]);
		log.setType(annotations[2]);
		
		//发布
		publisher.publish(log);
		
		
	}

}
