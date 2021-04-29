package com.cg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.BookException;
import com.cg.bookstore.exceptions.CategoryException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
@Transactional
public class BookService implements IBookService{
	
	@Autowired
	IBookRepository repository;
	
	@Autowired
	ICategoryRepository catrepo;

	@Override
	public Book createBook(Book b) throws BookException{
		if(!(repository.existsByBookId(b.getBookId()))) {
			Book bookData = repository.save(b);
			return bookData;
		}
		else
			throw new BookException("Book already exists");
	}

	@Override
	public List<Book> listAllBooks() throws BookException{
		List<Book> bookList = repository.findAll();
		if(bookList.isEmpty())
			throw new BookException("No Data Found");
		else
			return bookList;
	}

	@Override
	public void deleteBook(int bookId) throws BookException{
		if(repository.existsByBookId(bookId)){
			repository.deleteById(bookId);
		}
		else
			throw new BookException("Book not found");
	}

	@Override
	public Book editBook(Book b) throws BookException{
		if(repository.existsByBookId(b.getBookId())) {
			Book bookData = repository.save(b);
			return bookData;
		}
		else
			throw new BookException("Book not found");
	}

	@Override
	public Book viewBook(int bookId) throws BookException{
		if(repository.existsByBookId(bookId)) {
			Book bookData = repository.findByBookId(bookId);
			return bookData;
		}
		else
			throw new BookException("Book not found");
	}

	@Override
	public List<Book> listBooksByCategory(String cat) throws BookException, CategoryException {
		if(catrepo.existsByCategoryName(cat)) {
			Category category = catrepo.findByCategoryName(cat);
			List<Book> bookList = repository.findByCategory(category);
			if(bookList.isEmpty())
				throw new BookException("No books available");
			else
				return bookList;
		}
		else
			throw new CategoryException("Category invalid"); 
	}

	@Override
	public Book viewBookByTitle(String title) throws BookException {
		if(repository.existsByTitle(title)) {
			Book bookData = repository.findByTitle(title);
			return bookData;
		}
		else
			throw new BookException("Book not found");
	}

}
