package com.service.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.service.account.entity.Account;
import com.service.account.service.AccountService;
import com.util.AccountUtil;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AccountController {

	// constructor injection
	AccountService accountService;
	Environment environment; // for taking properties from application.properties file

	@Autowired
	public AccountController(AccountService accountService, Environment environment) {
		this.accountService = accountService;
		this.environment = environment;
	}

	//for exception
	int[] arr = {21,4,23,45};
	
	
	@GetMapping("/account-service")
	public String accountService() {

		return accountService.accountService();
	}

	@GetMapping("/account/{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable long accountId) {
		
		Optional<Account> account = accountService.getAccountById(accountId);
		return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
		/*try {
			Optional<Account> account = accountService.getAccountById(accountId);
			return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opps , cannot find the account");
		}*/
	}

	@GetMapping("/account")
	public ResponseEntity<List<Account>> getAccount() {
		return new ResponseEntity(accountService.getAccount(), HttpStatus.OK);
	}

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
	}

	@PutMapping("/account/{accId}")
	public ResponseEntity<Account> updateAccount(@PathVariable long accId, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccount(accId, account), HttpStatus.OK);
	}

	@DeleteMapping("/account/{accId}")
	public void deleteAccount(@PathVariable long accId) {
		accountService.deleteAccount(accId);
	}

	// value annotation
	@Value("${name}")
	String name;

	@GetMapping("/name")
	public String getName() {
		return name;
	}

	@GetMapping("/description")
	public String getNamebyEnv() {
		return environment.getProperty("description");
	}

	// setter injection for accoutnt util package
	AccountUtil accountUtil;

	@Autowired
	public void setAccountUtil(AccountUtil accountUtil) {
		this.accountUtil = accountUtil;
	}

	@GetMapping("/util")
	public String getAccountUtil() {
		return accountUtil.getAccountUtility();
	}

	// account type
	@GetMapping("/account-type")
	public String getAccountType() {
		return accountService.getAccountType();
	}

	@PostConstruct
	public void init() {
		System.out.println("Init call");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy call");
	}
	
	@GetMapping("/get-array")
	public void getArray()
	{
		System.out.println(arr[5]);
	}
/*
	@ExceptionHandler({IndexOutOfBoundsException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleException(HttpServletRequest request , Exception e)
	{
		return "Oops , cannot "+request.getMethod() + "this request , Exception :"+e.getMessage(); 
	}
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleAllExceptions(HttpServletRequest request , Exception e)
	{
		return "Exception :"+e.getMessage();
	}
	*/
}
