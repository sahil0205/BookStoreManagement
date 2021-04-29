package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.exceptions.BookException;

public interface IBookService {

	public Book createBook(Book b) throws BookException;

	public List<Book> listAllBooks() throws BookException;

	public void deleteBook(int bookId) throws BookException;

	public Book editBook(Book b) throws BookException;

	public Book viewBook(int bookId) throws BookException;

	public List<Book> listBooksByCategory(String cat) throws BookException;
	
	public Book viewBookByTitle(String title) throws BookException;

}
