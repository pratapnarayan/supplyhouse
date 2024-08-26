package com.supplyhouse.accounts;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BusinessOwnerAccount {
	
	@Id
	private int accountId;
    private List<String> subaccounts;
    
    public BusinessOwnerAccount() {
    	
    }

	public BusinessOwnerAccount(int accountId, List<String> subaccounts) {
		super();
		this.accountId = accountId;
		this.subaccounts = subaccounts;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public List<String> getSubaccounts() {
		return subaccounts;
	}

	public void setSubaccounts(List<String> subaccounts) {
		this.subaccounts = subaccounts;
	}
    
    

}
