package com.cg.bookstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.User;
import com.cg.bookstore.exceptions.UserException;
import com.cg.bookstore.service.ILoginService;

@RestController
@RequestMapping("/bookstore/user")
public class UserController {
	
	@Autowired
	ILoginService service;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/adduser")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		try {
			User userData = service.addUser(user);
			logger.info("Added new "+user.getRole());
			return new ResponseEntity<Object>(userData, HttpStatus.OK);
		}
		catch(UserException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/removeuser/{userId}")
	public ResponseEntity<Object> removeUser(@PathVariable int userId){
		try {
			service.removeUser(userId);
			logger.info("User removed");
			return new ResponseEntity<Object>("User Removed", HttpStatus.OK);
		}
		catch(UserException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/validateuser")
	public ResponseEntity<Object> validateUser(@RequestBody User user){
		try {
			service.validateUser(user.getEmail(), user.getPassword());
			logger.info("Sign in successful");
			return new ResponseEntity<Object>("Sign In succesful", HttpStatus.OK);
		}
		catch(UserException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
