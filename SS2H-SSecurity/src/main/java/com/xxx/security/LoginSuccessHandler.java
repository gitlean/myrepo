package com.xxx.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 处理管理员登录日志
 * 
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger logger=LoggerFactory.getLogger(LoginSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		logger.debug("debug sth....");
		logger.info("LoginSuccessHandler..........");
		logger.error("error sth ...");
		// 输出登录提示信息
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
		System.out.println("管理员 " + userDetails.getUsername() + " 登录");
		System.out.println("userDetails.getPassword()"+userDetails.getPassword());
		
		
		
		Iterator iter=userDetails.getAuthorities().iterator();
		while(iter.hasNext()){
			GrantedAuthority ins=(GrantedAuthority) iter.next();
			System.out.print(ins.getAuthority()+"\t");
			
		}
		
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
