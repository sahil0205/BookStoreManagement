package com.cg.bookstore.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.repository.ICategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class CategoryTests {
	
	@Autowired
	ICategoryRepository repository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testAddCategory() {
		Category categoryData = repository.save(new Category("Comics"));
		assertThat(categoryData.getCategoryId()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(2)
	public void testViewAllCategories() {
		List<Category> categoryList = repository.findAll();
		assertThat(categoryList.size()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(3)
	public void testEditCategory() {
		Category categoryData = repository.findByCategoryName("Comics");
		categoryData.setCategoryName("Comics 2");
		Category updatedData = repository.findByCategoryName("Comics 2");
		assertNotEquals(updatedData.getCategoryName(), "Comics");
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testDeleteCategory() {
		Category categoryData = repository.findByCategoryName("Comics 2");
		repository.delete(categoryData);
		assertFalse(repository.existsByCategoryName("Comics 2"));
	}
}
