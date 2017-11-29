package com.isoft.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*BeanPostProcessor接口定义了实例化逻辑、依赖逻辑等回调方法,即可以自定义也可以覆盖容器默认方法。若果要在Spring容器完成实例化、配置、初始化bean之后执行自定义逻辑,则以插件方式实现BeanPostProcessor。
可以配置多个BeanPostProcessor实例，可以设置BeanPostProcessors的order属性来控制其执行次序。让BeanPostProcessor实现Ordered接口，就能设置其属性。


作者：不迷失
链接：http://www.jianshu.com/p/924e06fa9b7d
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
@Component
public class ProductAwareBeanprocessor implements BeanPostProcessor {//, ApplicationContextAware

	private static ApplicationContext context;

	private Map<String, String> replaceableBeanNames;

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextHelper.context = context;
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public Map<String, String> getReplaceableBeanNames() {
		return replaceableBeanNames;
	}

	public void setReplaceableBeanNames(Map<String, String> replaceableBeanNames) {
		this.replaceableBeanNames = replaceableBeanNames;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		String productId = "xxx";

		if (null == replaceableBeanNames) {
			replaceableBeanNames = new HashMap<String, String>();
		}

		Collection<ProductAwareBean> cs = context.getBeansOfType(ProductAwareBean.class).values();
		if (cs.isEmpty()) {
			System.out.println("Empty");
		}

		// 可能有多个ProductAwareBean
		for (ProductAwareBean productAware : context.getBeansOfType(ProductAwareBean.class).values()) {
			// 这里可以根据条件判断是否执行以下代码,例如productId
			// if(productAware.getProductId().equals(productId)){}

			replaceableBeanNames.putAll(productAware.getReplaceableBeanNameRigistry());

		}

		if (replaceableBeanNames.containsKey(beanName)) {
			String targetBean = replaceableBeanNames.get(beanName);
			return context.getBean(targetBean); // 替换bean
		}

		return bean;

	}

}
