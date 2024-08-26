package com.supplyhouse.accounts;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SubAccount {
	
	@Id
	private int accountId;
    private String businessOwnerId;
    private Date linkedDate;
    private String shareOrderHistory;
    
    
    
	public SubAccount() {
		
	}
	
	
	
	public SubAccount(int accountId, String businessOwnerId, Date linkedDate, String shareOrderHistory) {
		super();
		this.accountId = accountId;
		this.businessOwnerId = businessOwnerId;
		this.linkedDate = linkedDate;
		this.shareOrderHistory = shareOrderHistory;
	}



	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getBusinessOwnerId() {
		return businessOwnerId;
	}
	public void setBusinessOwnerId(String businessOwnerId) {
		this.businessOwnerId = businessOwnerId;
	}
	public Date getLinkedDate() {
		return linkedDate;
	}
	public void setLinkedDate(Date linkedDate) {
		this.linkedDate = linkedDate;
	}
	public String getShareOrderHistory() {
		return shareOrderHistory;
	}
	public void setShareOrderHistory(String shareOrderHistory) {
		this.shareOrderHistory = shareOrderHistory;
	}
    
    
    

}
