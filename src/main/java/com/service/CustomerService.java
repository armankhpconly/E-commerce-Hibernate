package com.service;

import com.dto.Customer;

public interface CustomerService {
	void createCustomer(String name, String email,String city,int pincode);
	Customer searchCustomer(int id);
	Customer updateCustomer(int id, String name);
	void deleteCustomer(Customer customer);
	

}
