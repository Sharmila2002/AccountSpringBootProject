package com.service.account.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AccountControllerAdvice {

	@ExceptionHandler({IndexOutOfBoundsException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleException(HttpServletRequest request , Exception e)
	{
		return "Opps , "+request.getMethod()+ " "+ request.getRequestURI()+ " Exception :"+e.getMessage(); 
	}
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleAllExceptions(HttpServletRequest request , Exception e)
	{
		return "Something went wrong "+ request.getMethod() + " "+ request.getRequestURL()+" Exception :"+e.getMessage();
	}
	
}
