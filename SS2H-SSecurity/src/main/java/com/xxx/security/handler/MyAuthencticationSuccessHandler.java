package com.xxx.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * http://blog.csdn.net/superdog007/article/details/49757237
 * security3中用户登录成功后的处理
 * description 
 * @author john
 * @date 2017年10月24日
 */
public class MyAuthencticationSuccessHandler implements
		AuthenticationSuccessHandler {

	private Logger logger = LoggerFactory
			.getLogger(MyAuthencticationSuccessHandler.class);

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		logger.info("现在开始处理认证成功后的处理...");
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);

	}

	protected void handle(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			logger.debug("错误信息:Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	
	//还可以  根据不同的登录用户(权限)跳转到不同的页面
	protected String determineTargetUrl(Authentication authentication) {
		
//		boolean isUser = false;
//		Collection<? extends GrantedAuthority> authorities = authentication
//				.getAuthorities();
//		for (GrantedAuthority grantedAuthority : authorities) {
//			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
//				isUser = true;
//				break;
//			}
//		}
//		if (isUser) {
//			return "/index.jsp";
//		} else {
//			logger.error("security错误信息:");
//			throw new IllegalStateException();
//
//		}
		
		return "/manager/films.jsp";
		
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
