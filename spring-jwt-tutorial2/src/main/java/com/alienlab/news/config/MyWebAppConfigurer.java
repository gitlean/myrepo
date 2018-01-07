package com.alienlab.news.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alienlab.news.interceptor.ApiInterceptor;

/**
 * Created by Msater Zg on 2017/4/5. 拦截器管理工具
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns用于添加拦截规则
		// excludePathPatterns用户排除拦截
		registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/**"); // 对来自/user/**
																				// 这个链接来的请求进行拦截
		super.addInterceptors(registry);
	}
}
