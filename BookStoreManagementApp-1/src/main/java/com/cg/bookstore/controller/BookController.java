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

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.exceptions.BookException;
import com.cg.bookstore.exceptions.CategoryException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.service.IBookService;

@RestController
@RequestMapping("/bookstore/book")
public class BookController {
	
	@Autowired
	IBookService service;
	
	@Autowired
	IBookRepository repository;
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@PostMapping("/createbook")
	public ResponseEntity<Object> createBook(@RequestBody Book b){
		try {
			Book bookData = service.createBook(b);
			logger.info(b.getTitle()+" added");
			return new ResponseEntity<Object>(bookData, HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listallbooks")
	public ResponseEntity<Object> listAllBooks(){
		try {
			List<Book> bookList = service.listAllBooks();
			logger.info("Listing all books");
			return new ResponseEntity<Object>(bookList, HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<Object> deleteBook(@PathVariable int bookId){
		try {
			service.deleteBook(bookId);
			logger.info("Book deleted from database");
			return new ResponseEntity<Object>("Book Deleted", HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/editbook")
	public ResponseEntity<Object> editBook(@RequestBody Book b){
		try {
			Book bookData = service.editBook(b);
			logger.info(b.getTitle()+" updated");
			return new ResponseEntity<Object>(bookData, HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbook/{bookId}")
	public ResponseEntity<Object> viewBook(@PathVariable int bookId){
		try {
			Book bookData = service.viewBook(bookId);
			logger.info("Book viewed by Id");
			return new ResponseEntity<Object>(bookData, HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbooksbycategory/{categoryName}")
	public ResponseEntity<Object> viewBooksByCategory(@PathVariable String categoryName){
		try {
			List<Book> bookList = service.listBooksByCategory(categoryName);
			logger.info("View books by category: "+categoryName);
			return new ResponseEntity<Object>(bookList, HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(CategoryException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewbookbytitle/{title}")
	public ResponseEntity<Object> viewBookByTitle(@PathVariable String title){
		try {
			Book bookData = service.viewBookByTitle(title);
			logger.info("Book viewed by title: "+title);
			return new ResponseEntity<Object>(bookData, HttpStatus.OK);
		}
		catch(BookException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
