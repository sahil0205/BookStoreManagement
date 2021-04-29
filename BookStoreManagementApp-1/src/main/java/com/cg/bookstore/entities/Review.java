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

@Entity
@Table(name = "review_master")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "book_Id")
	private Book book;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private String headLine;
	private String comment;
	private double rating;
	private LocalDate reviewOn;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDate getReviewOn() {
		return reviewOn;
	}

	public void setReviewOn(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}

	public Review() {
		super();
	}

	public Review(Book book, Customer customer, String headLine, String comment, double rating, LocalDate reviewOn) {
		super();
		this.book = book;
		this.customer = customer;
		this.headLine = headLine;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
	}

	public Review(int reviewId, Book book, Customer customer, String headLine, String comment, double rating,
			LocalDate reviewOn) {
		super();
		this.reviewId = reviewId;
		this.book = book;
		this.customer = customer;
		this.headLine = headLine;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
	}

}
