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

import com.cg.bookstore.entities.Review;
import com.cg.bookstore.exceptions.ReviewExcpetion;
import com.cg.bookstore.service.IReviewService;

@RestController
@RequestMapping("/bookstore/review")
public class ReviewController {
	
	@Autowired
	IReviewService service;
	
	Logger logger = LoggerFactory.getLogger(ReviewController.class); 
	
	@PostMapping("/addreview")
	public ResponseEntity<Object> addReview(@RequestBody Review review){
		try {
			Review reviewData = service.addReview(review);
			logger.info("Review added for "+review.getBook().getTitle());
			return new ResponseEntity<Object>(reviewData, HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listallreview")
	public ResponseEntity<Object> listAllReviews(){
		try {
			List<Review> reviewList = service.listAllReviews();
			logger.info("Viewed all reviews");
			return new ResponseEntity<Object>(reviewList, HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletereview/{reviewId}")
	public ResponseEntity<Object> deleteReview(@PathVariable int reviewId){
		try {
			service.deleteReview(reviewId);
			logger.info("Review deleted");
			return new ResponseEntity<Object>("Review Deleted", HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("updatereview")
	public ResponseEntity<Object> updateReview(@RequestBody Review review){
		try {
			Review reviewData = service.updateReview(review);
			logger.info("Review updated for "+review.getBook().getTitle());
			return new ResponseEntity<Object>(reviewData, HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("viewreview/{reviewId}")
	public ResponseEntity<Object> viewReview(@PathVariable int reviewId){
		try {
			Review reviewData = service.viewReview(reviewId);
			logger.info("Viewed review by id");
			return new ResponseEntity<Object>(reviewData, HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("listallreviewbybook/{title}")
	public ResponseEntity<Object> listAllReviewByBook(@RequestParam String title){
		try {
			List<Review> reviewList = service.listAllReviewsByBook(title);
			logger.info("Viewed reviews for "+title);
			return new ResponseEntity<Object>(reviewList, HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("listallreviewbycustomer/{fullName}")
	public ResponseEntity<Object> listAllReviewByCustomer(@RequestParam String fullName){
		try {
			List<Review> reviewList = service.listAllReviewsByCustomer(fullName);
			logger.info("Viewed reviews from "+fullName);
			return new ResponseEntity<Object>(reviewList, HttpStatus.OK);
		}
		catch(ReviewExcpetion e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
