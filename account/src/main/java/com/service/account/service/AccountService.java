package com.service.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.service.account.entity.Account;
import com.service.account.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {

	AccountRepository accountRepository;
	IAccount iAccount;

	@Autowired
	public AccountService(@Qualifier("loanAccount") IAccount iAccount, AccountRepository accountRepo) {
		this.iAccount = iAccount;
		this.accountRepository = accountRepo;
	}

	public String getAccountType() {
		return iAccount.getAccountType();
	}

	public String accountService() {
		return "This is account service";
	}

	public Optional<Account> getAccountById(long accountId) {
		return accountRepository.findById(accountId);
	}

	public List<Account> getAccount() {
//		Account account = new Account();
//		account.setAccId(1);
//		account.setAccHolder("Sharmila Machindra Bhosale");
//		account.setAccBranch("Jejuri");
//		account.setAccType("Saving");

		log.info("AccountService::getAccountType()");
		return accountRepository.findAll();
	}

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account updateAccount(long accId, Account account) {
		Account updatedAccount;
		if (accountRepository.existsById(accId)) {
			Optional<Account> existAccount = accountRepository.findById(accId);
			Account oldAccount = existAccount.get();
			oldAccount.setAccHolder(account.getAccHolder());
			oldAccount.setAccBranch(account.getAccBranch());
			oldAccount.setAccType(account.getAccType());
			updatedAccount = accountRepository.save(oldAccount);
		} else {
			updatedAccount = accountRepository.save(account);
		}
		return updatedAccount;
	}

	public void deleteAccount(long accId) {
		accountRepository.deleteById(accId);
	}

	// constructor injection

}
