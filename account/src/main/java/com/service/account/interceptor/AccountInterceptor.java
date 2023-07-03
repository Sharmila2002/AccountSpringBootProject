package com.service.account.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AccountInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response , Object handler)throws Exception
	{
		System.out.println("in preHandler method");
		return true;
	}
	
	public void postHandle(HttpServletRequest request , HttpServletResponse response ,Object handler,ModelAndView modelAndView)throws Exception
	{
		System.out.println("in post handle method");
	}
	public void afterCompletion(HttpServletRequest request , HttpServletResponse response , Exception ex)throws Exception
	{
		System.out.println("after completion method");
	}
}
