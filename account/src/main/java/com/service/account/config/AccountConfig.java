package com.service.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.account.service.LoanAccount;

@Configuration
public class AccountConfig {
	
	@Bean
	public LoanAccount loanAccount()
	{
		return new LoanAccount();
	}

}
