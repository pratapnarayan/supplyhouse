package com.supplyhouse.accounts.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supplyhouse.accounts.Account;
import com.supplyhouse.accounts.Orders;

@Component
public class AccountDAO {
	
	
	private static List<Orders> orders = new ArrayList<>();
	
	public AccountDAO() {
		
	}
	
	static {
		
		orders.add(new Orders(201, 101, LocalDate.now().minusDays(15)));
		orders.add(new Orders(202, 102, LocalDate.now().minusDays(20)));
		orders.add(new Orders(203, 101, LocalDate.now().minusDays(35)));
		orders.add(new Orders(205, 103, LocalDate.now().minusDays(30)));
		
	}
	
	public int getOrderCount(Integer id) {
		
		LocalDate oneYear = LocalDate.now().minusYears(1);
		
		int count = (int) orders.stream()
        .filter(order -> (order.getAccountId() == id))
        .filter(order -> order.getOrderDate().isAfter(oneYear) || order.getOrderDate().isEqual(oneYear))
        .count();

		return count;
	}
	
}
