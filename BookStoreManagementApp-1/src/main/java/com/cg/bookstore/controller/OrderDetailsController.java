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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.OrderDetails;
import com.cg.bookstore.exceptions.OrderException;
import com.cg.bookstore.service.IOrderService;

@RestController
@RequestMapping("/bookstore/orderdetails")
public class OrderDetailsController {
	
	@Autowired
	IOrderService service;
	
	Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);
	
	@PostMapping("/addorderdetails")
	public ResponseEntity<Object> addOrderDetails(@RequestBody OrderDetails od){
		try {
			OrderDetails orderData = service.addOrder(od);
			logger.info("Added order details");
			return new ResponseEntity<Object>(orderData, HttpStatus.OK);
		}
		catch(OrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getorderbybook/{title}")
	public ResponseEntity<Object> listByBook(@RequestParam String title){
		try {
			List<OrderDetails> orderList = service.viewOrderByBook(title);
			logger.info("Orders listed by book");
			return new ResponseEntity<Object>(orderList, HttpStatus.OK);
		}
		catch(OrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listallorders")
	public ResponseEntity<Object> listAllOrders(){
		try {
			List<OrderDetails> orderList = service.listAllOrders();
			logger.info("Viewed all orders");
			return new ResponseEntity<Object>(orderList, HttpStatus.OK);
		}
		catch(OrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateorder")
	public ResponseEntity<Object> updateorder(@RequestBody OrderDetails od){
		try {
			OrderDetails orderData = service.updateOrder(od);
			logger.info("Order updated");
			return new ResponseEntity<Object>(orderData, HttpStatus.OK);
		}
		catch(OrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cancelorder/{detailId}")
		public ResponseEntity<Object> cancelOrder(@PathVariable int detailId){	
		try {
			service.cancelOrder(detailId);
			logger.info("Order cancelled");
			return new ResponseEntity<Object>("Order Cancelled", HttpStatus.OK);
		}
		catch(OrderException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
