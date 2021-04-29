package com.cg.bookstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.exceptions.CustomerException;
import com.cg.bookstore.service.ICustomerService;

@RestController
@RequestMapping("/bookstore/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/createcustomer")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer c){
		try {
			Customer customerData = service.createCustomer(c);
			logger.info(c.getFullName()+" added to database");
			return new ResponseEntity<Object>(customerData, HttpStatus.OK);
		}
		catch(CustomerException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listcustomers")
	public ResponseEntity<Object> listCustomers(){
		try {
			List<Customer> customerList = service.listCustomers();
			logger.info("Viewed customer list");
			return new ResponseEntity<Object>(customerList, HttpStatus.OK);
		}
		catch(CustomerException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletecustomer/{customerId}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int customerId){
		try {
			service.deleteCustomer(customerId);
			logger.info("Customer deleted");
			return new ResponseEntity<Object>("Customer Deleted", HttpStatus.OK);
		}
		catch(CustomerException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewcustomer/{customerId}")
	public ResponseEntity<Object> viewCustomer(@PathVariable int customerId){
		try {
			Customer customerData = service.viewCustomer(customerId);
			logger.info("Customer viewed by Id");
			return new ResponseEntity<Object>(customerData, HttpStatus.OK);
		}
		catch(CustomerException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer){
		try {
			Customer customerData = service.createCustomer(customer);
			logger.info("Customer updated");
			return new ResponseEntity<Object>(customerData, HttpStatus.OK);
		}
		catch(CustomerException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
