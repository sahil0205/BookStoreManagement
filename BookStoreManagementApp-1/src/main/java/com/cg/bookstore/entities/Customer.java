package com.cg.bookstore.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_master")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String email;
	private String fullName;
	private String password;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
	private String mobileNumber;
	private LocalDate registerOn;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getRegisterOn() {
		return registerOn;
	}

	public void setRegisterOn(LocalDate registerOn) {
		this.registerOn = registerOn;
	}

	public Customer() {
		super();
	}

	public Customer(String email, String fullName, String password, Address address, String mobileNumber,
			LocalDate registerOn) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.registerOn = registerOn;
	}

	public Customer(int customerId, String email, String fullName, String password, Address address,
			String mobileNumber, LocalDate registerOn) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.registerOn = registerOn;
	}
}
