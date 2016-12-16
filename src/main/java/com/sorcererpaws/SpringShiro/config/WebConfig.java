package com.sorcererpaws.SpringShiro.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sorcererpaws.SpringShiro.filter.AnyOfRolesAuthorizationFilter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sorcererpaws.SpringShiro" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private WebSecurityManager webSecurityManager;
	/*@Autowired
	private CustomLogoutFilter customLogoutFilter;*/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ViewResolver viewResolver() 
	{

		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Bean
	public MessageSource messageSource() 
	{

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(5);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() 
	{

		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setCookieName("LOCALE");
		return cookieLocaleResolver;
	}

	@Bean
	public FormAuthenticationFilter formAuthenticationFilter() 
	{

		FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
		formAuthenticationFilter.setUsernameParam("username");
		formAuthenticationFilter.setPasswordParam("password");
		formAuthenticationFilter.setLoginUrl("/login");

		return formAuthenticationFilter;
	}

	@Bean
	public LogoutFilter logoutFilter() 
	{

		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/login");
		return logoutFilter;
	}
	
	@Bean
	public AnyOfRolesAuthorizationFilter anyOfRolesAuthorizationFilter() {
		return new AnyOfRolesAuthorizationFilter();
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() 
	{

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		Map<String, Filter> filters = new HashMap<>();
		filters.put("authc", formAuthenticationFilter());
		filters.put("anyofroles", anyOfRolesAuthorizationFilter());
		//filters.put("logout", customLogoutFilter);
		filters.put("logout", logoutFilter());

		Map<String, String> filterChainDefinitionMap = new HashMap<>();
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/unauthorized", "anon");
		filterChainDefinitionMap.put("/login", "authc");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/success", "authc, anyofroles[lab, admin]");
		filterChainDefinitionMap.put("/lab/**", "authc, roles[lab]");
		filterChainDefinitionMap.put("/admin/**", "authc, roles[admin]");

		shiroFilterFactoryBean.setSecurityManager(webSecurityManager);

		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

		shiroFilterFactoryBean.setFilters(filters);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		shiroFilterFactoryBean.setSuccessUrl("/success");

		return shiroFilterFactoryBean;
	}

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
	{
		SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("org.springframework.dao.DataAccessException", "error");
		b.setExceptionMappings(mappings);
		return b;
	}
}
