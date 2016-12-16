package com.sorcererpaws.SpringShiro.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SecurityConfig {

	@Bean
	public CustomSecurityRealm customSecurityRealm() {
		
		return new CustomSecurityRealm();
	}
	
	@Bean
	public WebSecurityManager webSecurityManager() {
		
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(customSecurityRealm());
		return defaultWebSecurityManager;
	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		
		return new LifecycleBeanPostProcessor();
	}
	
	@Bean
	public MethodInvokingFactoryBean methodInvokingFactoryBean() {
		
		MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
		methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		methodInvokingFactoryBean.setArguments(new Object[]{ webSecurityManager() });
		return methodInvokingFactoryBean;
	}
	
	@Bean
	@DependsOn(value = "lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		
		return new DefaultAdvisorAutoProxyCreator();
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(webSecurityManager());
		return authorizationAttributeSourceAdvisor;
	}
}
