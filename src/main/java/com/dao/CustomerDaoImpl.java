package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dto.Address;
import com.dto.Customer;

import utility.Utility;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer savesCustomer(Customer customer, Address address) {
		// TODO Auto-generated method stub
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		transaction.begin();
		eManager.persist(address);
		eManager.persist(customer);
		transaction.commit();
		eManager.close();
		return customer;
	}

	@Override
	public Customer searchCustomer(int id) {
		EntityManager entityManager = Utility.getEntityManager();
		EntityTransaction eTransaction = entityManager.getTransaction();
		eTransaction.begin();
		Customer customer = entityManager.find(Customer.class, id);
		eTransaction.commit();
		entityManager.close();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		eManager.merge(customer);
		eTransaction.commit();
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		Customer merge = eManager.merge(customer);
		eManager.remove(merge);
		eTransaction.commit();
		eManager.close();		
	}
	

}
