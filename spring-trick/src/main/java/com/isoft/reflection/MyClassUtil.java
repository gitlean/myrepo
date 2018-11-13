package com.isoft.reflection;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import com.isoft.reflection.mif.Ioperator;

/**
 * 
 * @author john
 * @date 2018年10月23日
 * @time 下午2:41:29
 * @describe:查找某个package下实现某个接口的 所有类
 */
public class MyClassUtil extends ReflectionUtils {
	public static Set<Class<?>> findCandiateClass(Predicate<Class<?>> predicate,String... packages){
		if(0==packages.length){
			throw new IllegalArgumentException();
		}
		
		Set<Class<?>> set=new HashSet<>();
		ResourceLoader resourceLoader=null;
		CachingMetadataReaderFactory readerFactory=new CachingMetadataReaderFactory(resourceLoader);
		ResourcePatternResolver resolver=ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
		
		for(String packageName:packages){
			String packageSearchPath=ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+ClassUtils.convertClassNameToResourcePath(new StandardEnvironment().resolvePlaceholders(packageName))+"/**/*.class";
			
			try {
				Resource[] resources=resolver.getResources(packageSearchPath);
				for(Resource resource:resources){
					MetadataReader metadataReader=readerFactory.getMetadataReader(resource);
					
					Class<?> clazz=Class.forName(metadataReader.getClassMetadata().getClassName());
					if(predicate.test(clazz)){
						set.add(clazz);
					}
				}
				
			} catch (IOException |ClassNotFoundException e) {
				
				throw new RuntimeException(e);
			}
		}
		
		
		return set;
	}
	
	
	/**
	 * 找到  packages 下所有实现   interfaceClass 的类
	 * @param interfaceClass
	 * @param packages
	 * @return
	 */
	public static Set<Class<?>> implementingClassOf(Class<?> interfaceClass,String... packages){
		if(!interfaceClass.isInterface()){
			throw new IllegalArgumentException();
		}
		
		return findCandiateClass(clazz -> interfaceClass.isAssignableFrom(clazz)  && ! clazz.isInterface(),packages);
	}
	

//	public static void call(String... args){
//		System.out.println(args.length);
//	}
	
//	public static void call(String[] args){
//		System.out.println(args.length);
//	}
//	
//	
	public static void main(String[] args) {
		 Set<Class<?>> set=implementingClassOf(Ioperator.class,"com.isoft.reflection.mif");
		 System.out.println(set.size());
	}

}
