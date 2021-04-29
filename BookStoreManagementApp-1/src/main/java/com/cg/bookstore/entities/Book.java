package com.cg.bookstore.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book_master")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@NotNull
	@Size(min=2, max=30, message = "Title should be between 2 to 30 charcters")
	private String title;
	@NotNull
	@Size(min=2, max=30, message = "Author should be between 2 to 30 charcters")
	private String author;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	@NotNull
	@Size(min=2, max=50, message = "Description should be between 2 to 50 charcters")
	private String description;
	
	private String isbn;
	private double price;
	private LocalDate publishDate;
	private LocalDate lastUpdatedOn;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Book() {
		super();
	}

	public Book(String title, String author, Category category, String description, String isbn, double price,
			LocalDate publishDate, LocalDate lastUpdatedOn) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Book(int bookId, String title, String author, Category category, String description, String isbn,
			double price, LocalDate publishDate, LocalDate lastUpdatedOn) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdatedOn = lastUpdatedOn;
	}

}
