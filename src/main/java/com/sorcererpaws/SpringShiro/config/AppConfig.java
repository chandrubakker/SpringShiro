package com.sorcererpaws.SpringShiro.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = {"com.sorcererpaws.SpringShiro"}, 
excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.sorcererpaws.SpringShiro.web.*"}))
@PropertySource(value = { "classpath:application.properties" })
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
public class AppConfig {
	
	@Autowired
	private Environment environment;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public CacheManager cacheManager()
	{
		return new ConcurrentMapCacheManager();
	}
	
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(environment.getProperty("smtp.host"));
		mailSenderImpl.setPort(environment.getProperty("smtp.port", Integer.class));
		mailSenderImpl.setProtocol(environment.getProperty("smtp.protocol"));
		mailSenderImpl.setUsername(environment.getProperty("smtp.username"));
		mailSenderImpl.setPassword(environment.getProperty("smtp.password"));

		Properties javaMailProps = new Properties();
		javaMailProps.put("mail.smtp.auth", true);
		javaMailProps.put("mail.smtp.starttls.enable", true);

		mailSenderImpl.setJavaMailProperties(javaMailProps);

		return mailSenderImpl;
	}
}
