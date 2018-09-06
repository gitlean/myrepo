package com.isoft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.isoft.config.Audience;
import com.isoft.filter.HTTPBasicAuthorizeAttribute;
import com.isoft.filter.HTTPBearerAuthorizeAttribute;

/**
 * 
 * @author john
 * @date 2018年1月3日
 * @time 下午12:59:13
 * @describe:在Application类中注册过滤器，
 */

//@EnableConfigurationProperties(Audience.class)
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	// 给/user/*都加上http basic认证过滤器
//	@Bean
//	public FilterRegistrationBean basicFilterRegistrationBean() {
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//		HTTPBasicAuthorizeAttribute httpBasicFilter = new HTTPBasicAuthorizeAttribute();
//		registrationBean.setFilter(httpBasicFilter);
//		List<String> urlPatterns = new ArrayList<String>();
//		urlPatterns.add("/user/getuser");
//		registrationBean.setUrlPatterns(urlPatterns);
//		return registrationBean;
//	}

	/*
	//给/user/*都加上http Bearer认证过滤器                Bearer	持票人; 送信人; 搬运工人
	@Bean
	public FilterRegistrationBean jwtFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HTTPBearerAuthorizeAttribute httpBearerFilter = new HTTPBearerAuthorizeAttribute();
		registrationBean.setFilter(httpBearerFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/user/getusers");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
*/
}
