package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.CategoryException;

public interface ICategoryService {

	public Category addCategory(String categoryName) throws CategoryException;
	public Category editCategory(Category category) throws CategoryException;
	public List<Category> viewAllCategories() throws CategoryException;
	public void removeCategory(int categoryId) throws CategoryException;
}
