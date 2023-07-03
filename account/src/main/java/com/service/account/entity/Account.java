package com.service.account.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {

	@Id
	private long accId;
	@NotNull
	@NotBlank(message="Account Holder name is mandatory")
	private String accHolder;
	@Min(2)
	@Max(60)
	private String accBranch;
	@NotNull
	@NotBlank(message="account type is mandatory")
	private String accType;

//	public long getAccId() {
//		return accId;
//	}
//
//	public void setAccId(long accId) {
//		this.accId = accId;
//	}
//
//	public String getAccHolder() {
//		return accHolder;
//	}
//
//	public void setAccHolder(String accHolder) {
//		this.accHolder = accHolder;
//	}
//
//	public String getAccBranch() {
//		return accBranch;
//	}
//
//	public void setAccBranch(String accBranch) {
//		this.accBranch = accBranch;
//	}
//
//	public String getAccType() {
//		return accType;
//	}
//
//	public void setAccType(String accType) {
//		this.accType = accType;
//	}

}
