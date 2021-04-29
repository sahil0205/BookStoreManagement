package com.cg.bookstore.entities;

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
@Table(name = "orderdetails_master")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailId;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "book_Id")
	private Book book;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private BookOrder bookOrder;
	private int quantity;
	private double subtotal;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookOrder getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public OrderDetails() {
		super();
	}

	public OrderDetails(Book book, BookOrder bookOrder, int quantity, double subtotal) {
		super();
		this.book = book;
		this.bookOrder = bookOrder;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public OrderDetails(int detailId, Book book, BookOrder bookOrder, int quantity, double subtotal) {
		super();
		this.detailId = detailId;
		this.book = book;
		this.bookOrder = bookOrder;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

}
