package com.service.account.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Aspect
@Slf4j
public class AccountAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("execution(* com.service.account.controller.*.*(..))")
	public void before(JoinPoint joinPoint)
	{
		logger.info("before execution");
		log.info("Allow execution for {}" , joinPoint);
	}
	@AfterReturning(value="execution(* com.service.account.controller.*.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result)
	{
		log.info("after returning",joinPoint,result);
	}
	
	@After("execution(* com.service.account.controller.*.*(..))")
	public void after(JoinPoint joinPoint)
	{
		log.info("after execution");
		log.info("After execution", joinPoint);
	}
	
	
}
