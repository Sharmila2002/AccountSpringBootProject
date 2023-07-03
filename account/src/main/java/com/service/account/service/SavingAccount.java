package com.service.account.service;

import org.springframework.stereotype.Component;

@Component
public class SavingAccount implements IAccount {

	@Override
	public String getAccountType() {
		
		return "Saving account";
	}

}
