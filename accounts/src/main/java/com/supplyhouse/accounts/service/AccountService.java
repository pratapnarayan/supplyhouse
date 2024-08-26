package com.supplyhouse.accounts.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplyhouse.accounts.Account;
import com.supplyhouse.accounts.BusinessOwnerAccount;
import com.supplyhouse.accounts.dao.AccountDAO;

@Service
public class AccountService {
	
	
	private static List<Account> accounts = new ArrayList<>();
	private static Integer accountId = 100;
	
	//@Autowired
	private AccountDAO accountDao;
	
	private BusinessOwnerAccount boa;
	
	static {
		accounts.add(new Account(++accountId, LocalDate.now().minusMonths(2)));
		accounts.add(new Account(++accountId, LocalDate.now().minusMonths(1)));
		accounts.add(new Account(++accountId, LocalDate.now().minusMonths(4)));
		accounts.add(new Account(++accountId, LocalDate.now().minusMonths(5)));
	}
	
    @SuppressWarnings("null")
	public boolean requestUpgrade(int accountId) {
    	
    	int orderCount = accountDao.getOrderCount(accountId);
    	
    	if(orderCount >=10) {
    		return true;
    	}
    	
        return false; 
    }
    
    public void addAccountToBusinessOwner(int accountId) {
    	
    	boa.setAccountId(accountId);
    	boa.setSubaccounts(null);
    }
}