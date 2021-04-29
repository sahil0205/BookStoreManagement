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

import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.exceptions.BookOrderException;
import com.cg.bookstore.service.IBookOrderService;

@RestController
@RequestMapping("/bookstore/bookorder")
public class BookOrderController {
	
	@Autowired
	IBookOrderService service;
	
	Logger logger = LoggerFactory.getLogger(BookOrderController.class);
	
	@PostMapping("/addbookorder")
	public ResponseEntity<Object> addBookOrder(@RequestBody BookOrder bo){
		try {
			BookOrder orderData = service.addBookOrder(bo);
			logger.info("New Order added");
			return new ResponseEntity<Object>(orderData, HttpStatus.OK);
		}
		catch(BookOrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cancelbooking/{orderId}")
	public ResponseEntity<Object> cancelBookOrder(@PathVariable int orderId){
		try {
			service.cancelBookOrder(orderId);
			logger.info("Order Cancelled");
			return new ResponseEntity<Object>("Order Cancelled", HttpStatus.OK);
		}
		catch(BookOrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbookorder/{orderId}")
	public ResponseEntity<Object> viewBookOrder(@PathVariable int orderId){
		try {
			BookOrder orderData = service.viewBookOrder(orderId);
			logger.info("Order viewed by Id");
			return new ResponseEntity<Object>(orderData, HttpStatus.OK);
		}
		catch(BookOrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listall")
	public ResponseEntity<Object> listAll(){
		try {
			List<BookOrder> orderList = service.listAll();
			logger.info("List all orders");
			return new ResponseEntity<Object>(orderList, HttpStatus.OK);
		}
		catch(BookOrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updatebookorder")
	public ResponseEntity<Object> updateBookOrder(@RequestBody BookOrder bo){
		try {
			BookOrder orderData = service.updatebookOrder(bo);
			logger.info("Order updated");
			return new ResponseEntity<Object>(orderData, HttpStatus.OK); 
		}
		catch(BookOrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
