package com.service;


import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dto.Address;
import com.dto.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void createCustomer(String name, String email, String city,int pincode) {
		Address address = new Address();
		address.setCity(city);
		address.setPincode(pincode);
		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setAddress(address);
		customerDao.savesCustomer(customer,address);
	}
	@Override
	public Customer searchCustomer(int id) {
		Customer searchCustomer = customerDao.searchCustomer(id);
		return searchCustomer;
	}
	@Override
	public Customer updateCustomer(int id, String name) {
		Customer targetCustomer = customerDao.searchCustomer(id);
		targetCustomer.setName(name);
		Customer updateCustomer = customerDao.updateCustomer(targetCustomer);
		return updateCustomer;
		
	}
	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		System.out.println("deleted");
	}

}
