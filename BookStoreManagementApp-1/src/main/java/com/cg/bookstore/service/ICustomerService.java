package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.exceptions.CustomerException;

public interface ICustomerService {

	public Customer createCustomer(Customer c) throws CustomerException;
	public List<Customer> listCustomers() throws CustomerException;
	public void deleteCustomer(int customerId) throws CustomerException;
	public Customer updateCustomer(Customer c) throws CustomerException;
	public Customer viewCustomer(int customerId) throws CustomerException;
	//public List<Customer> listAllCustomersByBook(Book book) throws CustomerException;

	
}
