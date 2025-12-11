package com.dto;

import javax.persistence.*;

@Entity
public class Address {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int address_id;
		private String city;
		private int pincode;
@Override
public String toString() {
	return "Address [address_id=" + address_id + ", city=" + city + ", pincode=" + pincode + "]";
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
}
