package com.cg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.exceptions.CustomerException;
import com.cg.bookstore.repository.ICustomerRepository;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerRepository repository;

	@Override
	public Customer createCustomer(Customer c) throws CustomerException {
		if (repository.existsByCustomerId(c.getCustomerId()))
			throw new CustomerException("Customer already exists");
		else {
			Customer customerData = repository.save(c);
			return customerData;
		}
	}

	@Override
	public List<Customer> listCustomers() throws CustomerException {
		List<Customer> customerList = repository.findAll();
		if (customerList.isEmpty())
			throw new CustomerException("No data found");
		else
			return customerList;
	}

	@Override
	public void deleteCustomer(int customerId) throws CustomerException {
		if (repository.existsByCustomerId(customerId)) {
			repository.deleteById(customerId);
		} else
			throw new CustomerException("Customer not found");
	}

	@Override
	public Customer updateCustomer(Customer c) throws CustomerException {
		if (repository.existsByCustomerId(c.getCustomerId())) {
			return repository.save(c);
		} else
			throw new CustomerException("Customer not found");
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerException {
		if (repository.existsByCustomerId(customerId)) {
			return repository.findByCustomerId(customerId);
		} else
			throw new CustomerException("Customer Invalid");
	}
}
