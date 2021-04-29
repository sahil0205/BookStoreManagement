package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	public Category getByCategoryId(int categoryId);
	public boolean existsByCategoryName(String categoryName);
	public Category findByCategoryName(String categoryName);
}
