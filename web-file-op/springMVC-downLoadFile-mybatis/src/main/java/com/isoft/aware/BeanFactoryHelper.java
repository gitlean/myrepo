package com.isoft.aware;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryHelper implements BeanFactoryAware {

	private static BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public static Object getBean(String beanName) {
		if (beanFactory == null) {
			throw new NullPointerException("BeanFactory is null!");
		}
		return beanFactory.getBean(beanName);
	}
	
	public static <T>T getBean(String beanName,Class<T> clazz) {
		if (beanFactory == null) {
			throw new NullPointerException("BeanFactory is null!");
		}
		return beanFactory.getBean(beanName,clazz);
	}
	
	
}
