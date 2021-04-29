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

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.CategoryException;
import com.cg.bookstore.service.ICategoryService;

@RestController
@RequestMapping("/bookstore/category")
public class CategoryController {
	
	@Autowired
	ICategoryService service;
	
	Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@PostMapping("/addcategory")
	public ResponseEntity<Object> addCategory(@RequestBody String categoryName){
		try {
			Category categoryData = service.addCategory(categoryName);
			logger.info(categoryName+" added");
			return new ResponseEntity<Object>(categoryData, HttpStatus.OK);
		}
		catch(CategoryException e){
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
	}
	
	@PutMapping("/editcategory")
	public ResponseEntity<Object> editCategory(@RequestBody Category category){
		try {
			Category categoryData = service.editCategory(category);
			logger.info("Category edited");
			return new ResponseEntity<Object>(categoryData, HttpStatus.OK);
		}
		catch(CategoryException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}	
	}
	
	@GetMapping("/allcategories")
	public ResponseEntity<Object> viewAllCategories(){
		try {
			List<Category> categoryList = service.viewAllCategories();
			logger.info("Viewed category list");
			return new ResponseEntity<Object>(categoryList, HttpStatus.OK);
		}
		catch(CategoryException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletecategory/{categoryId}")
	public ResponseEntity<Object> removeCategory(@PathVariable int categoryId){
		try {
			service.removeCategory(categoryId);
			logger.info("Category removed");
			return new ResponseEntity<Object>("Category Removed", HttpStatus.OK);
		}
		catch(CategoryException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
	}
}
