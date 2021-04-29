package com.cg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.CategoryException;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
@Transactional
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryRepository repository;
	
	@Override
	public Category addCategory(String categoryName) throws CategoryException{
		if(repository.existsByCategoryName(categoryName))
			throw new CategoryException("Category Name already exists");
		else {
			Category newCategory = new Category(categoryName);
			return repository.save(newCategory);
		}
	}

	@Override
	public Category editCategory(Category category) {
		if(repository.existsById(category.getCategoryId())) {
			Category categoryData = repository.save(category);
			return repository.save(categoryData);
		}
		else
			throw new CategoryException("Category doesn't exists");
	}

	@Override
	public List<Category> viewAllCategories() {
		List<Category> categoryList = repository.findAll();
		if(categoryList.isEmpty())
			throw new CategoryException("No Data Available");
		else {
			return categoryList;
		}
	}

	@Override
	public void removeCategory(int categoryId) {
		if(repository.existsById(categoryId)) {
			Category categoryData = repository.getByCategoryId(categoryId);
			repository.delete(categoryData);
		}
		else
			throw new CategoryException("Category doesn't exists");
	}

}
