package com.service.account.service;

import org.springframework.stereotype.Component;

@Component
public class CurrentAccount implements IAccount {

	@Override
	public String getAccountType() {

		return "Current account";
	}

}
