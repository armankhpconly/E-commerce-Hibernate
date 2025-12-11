package com.service;

import com.dto.Address;

public interface AddressService {
	public Address createAddress(String city, int pincode);

}
