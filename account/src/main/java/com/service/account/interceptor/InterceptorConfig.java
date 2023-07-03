package com.service.account.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private AccountInterceptor accountInterceptor;
	
	public void addInterceptora(InterceptorRegistry registry)
	{
		registry.addInterceptor(accountInterceptor);
	}
}
