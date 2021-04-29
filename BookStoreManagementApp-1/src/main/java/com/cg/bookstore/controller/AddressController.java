package com.cg.bookstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Address;
import com.cg.bookstore.repository.IAddressRepository;

@RestController
@RequestMapping("/bookstore/address")
public class AddressController {

	@Autowired
	IAddressRepository repository;
	
	Logger logger = LoggerFactory.getLogger(Address.class);
	
	@PostMapping("/addaddress")
	public ResponseEntity<Object> addAddress(@RequestBody Address ad){
		Address addressData = repository.save(ad);
		logger.info("New address added");
		return new ResponseEntity<Object>(addressData, HttpStatus.OK);
	}
}
