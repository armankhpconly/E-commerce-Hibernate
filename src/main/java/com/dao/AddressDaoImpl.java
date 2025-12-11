package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dto.Address;

import utility.Utility;

public class AddressDaoImpl implements AddressDao {

	@Override
	public Address saveAddress(Address address) {

		EntityManager eManager = Utility.getEntityManager();
		EntityTransaction entityTransaction = eManager.getTransaction();
		entityTransaction.begin();
		eManager.persist(address);
		entityTransaction.commit();
		eManager.close();
		return address;
		
	}

}
