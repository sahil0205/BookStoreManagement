package com.cg.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address_master")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@NotNull
	@Size(min=2, max=30, message = "Address length should be between 2 to 30 charcters")
	private String address;
	@NotNull
	@Size(min=2, max=10, message = "City Name length should be between 2 to 10 charcters")
	private String city;
	@NotNull
	@Size(min=2, max=10, message = "Country Name length should be between 2 to 10 charcters")
	private String country;
	@NotNull
	@Size(min=2, max=6, message = "Pincode should be between 2 to 6 charcters")
	private String pincode;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	public Address(String address, String city, String country, String pincode) {
		super();
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	public Address(int addressId, String address, String city, String country, String pincode) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}
}
