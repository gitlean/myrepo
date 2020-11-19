package com.isoft.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 路径工具类
 * @author john
 * @date 2018年3月26日
 * @time 下午2:58:38
 * @describe:
 */
public class PathUtil {
	static Logger logger = LoggerFactory.getLogger(PathUtil.class);  
	
	
	public static String getClasspath(){
		
		
		String tt=String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));
		
		logger.debug(tt);//file:/E:/apache-tomcat-8.0.46/webapps/springMVC-downLoadFile/WEB-INF/classes/
		
		String path=(tt+"../../").replaceAll("file:/", "").replaceAll("%20", " ").trim();
		
		if(path.indexOf(":")!=1){
			path=File.separator+path;
		}
		
		logger.debug(path);
		return path;
	}
	
	public static String getClassResources(){
	String tt=String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));
		
		logger.debug(tt);//file:/E:/apache-tomcat-8.0.46/webapps/springMVC-downLoadFile/WEB-INF/classes/
		
		String path=tt.replaceAll("file:/", "").replaceAll("%20", " ").trim();
		
		if(path.indexOf(":")!=1){
			path=File.separator+path;
		}
		
		logger.debug(path);
		return path;
	}

}
