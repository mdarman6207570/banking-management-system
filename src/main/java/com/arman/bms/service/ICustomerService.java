package com.arman.bms.service;

import com.arman.bms.entity.Customer;

public interface ICustomerService {
   
	void registerCustomer(Customer customer);
	Customer login(String email, String password);
}
