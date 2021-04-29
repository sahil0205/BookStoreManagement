package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

	public boolean existsByBookId(int bookId);
	public Book findByBookId(int bookId); 
	public List<Book> findByCategory(Category category);
	public Book findByTitle(String title);
	public boolean existsByTitle(String title);
}
