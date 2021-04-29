package com.cg.bookstore.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
@TestMethodOrder(OrderAnnotation.class) 
public class BookTests {
	
	@Autowired
	IBookRepository repository;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateBook() {
		Category categoryData = categoryRepository.save(new Category("Fiction"));
		Book bookData = repository.save(new Book("Trainspotting", "Irvine Welsh", categoryData, "Nice", "DFSD1233", 500, LocalDate.now(), LocalDate.now()));
		assertThat(bookData.getBookId()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(2)
	public void testListAllBooks() {
		List<Book> bookList = repository.findAll();
		assertThat(bookList.size()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(3)
	public void testViewBookByTitle() {
		Book bookData = repository.findByTitle("Trainspotting");
		assertEquals(bookData.getTitle(), "Trainspotting");
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testListAllBooksByCategory() {
		Category categoryData = categoryRepository.findByCategoryName("Fiction");
		List<Book> bookList = repository.findByCategory(categoryData);
		assertThat(bookList.size()).isEqualTo(1);
	}
	
	@Test
	@Rollback(false)
	@Order(5)
	public void testEditBook() {
		Book bookData = repository.findByTitle("Trainspotting");
		bookData.setPrice(1000);
		repository.save(bookData);
		assertThat(repository.findByTitle("Trainspotting").getPrice()).isEqualTo(1000);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testDeleteBook() {
		Book bookData = repository.findByTitle("Trainspotting");
		repository.deleteById(bookData.getBookId());
		assertFalse(repository.existsByBookId(bookData.getBookId()));
	}
}
