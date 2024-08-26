package com.supplyhouse.accounts;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	@Id
	private int accountId;
    private LocalDate creationDate;
    
    
    
	public Account() {
		
	}
	public Account(int accountId, LocalDate creationDate) {
		super();
		this.accountId = accountId;
		this.creationDate = creationDate;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

}
