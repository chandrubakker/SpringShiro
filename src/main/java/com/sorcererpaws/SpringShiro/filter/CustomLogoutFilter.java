package com.sorcererpaws.SpringShiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomLogoutFilter extends LogoutFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogoutFilter.class);
	private String redirectUrl = "/login?logout";
	
	@Override
	public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception)
			throws Exception {
		
		LOGGER.info("Inside the afterCompletion()");
		LOGGER.info(":::::::::::::::::::::::::Redirecting to URL:::::::::::::::::::: " + getRedirectUrl());
		//cleanup(request, response, exception);
		setRedirectUrl(redirectUrl);
		LOGGER.info("::::::::::::::::::: Redirecting to URL AFTER:::::::::::::::::: " + getRedirectUrl());
	}
}
