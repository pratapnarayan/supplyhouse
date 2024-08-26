package com.supplyhouse.accounts;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
	
	@Id
	private int orderId;
	
    private int accountId;
    private LocalDate orderDate;
    
    
    
	public Orders() {
		
	}

	public Orders(int orderId, int accountId, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.accountId = accountId;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
    
    

}
