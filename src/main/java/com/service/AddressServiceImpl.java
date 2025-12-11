package com.service;

import com.dao.AddressDao;
import com.dao.AddressDaoImpl;
import com.dto.Address;

public class AddressServiceImpl implements AddressService {

	@Override
	public Address createAddress(String city, int pincode) {
		AddressDao addressDao = new AddressDaoImpl()
		Address address = new Address();
		address.setCity(city);
		address.setPincode(pincode);
		Address savedAddress = addressDao.saveAddress(address);
		return savedAddress;
		
		
	}

}
