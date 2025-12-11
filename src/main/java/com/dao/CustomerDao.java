package com.dao;

import com.dto.Address;
import com.dto.Customer;

public interface CustomerDao {
		Customer savesCustomer(Customer customer, Address address);
		Customer searchCustomer(int id);
		Customer updateCustomer(Customer customer);
		void deleteCustomer(Customer customer);
}
