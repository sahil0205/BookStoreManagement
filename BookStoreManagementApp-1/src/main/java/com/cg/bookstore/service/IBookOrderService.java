package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.exceptions.BookOrderException;

public interface IBookOrderService {
	public BookOrder addBookOrder(BookOrder bo) throws BookOrderException;
	public void cancelBookOrder(int orderId) throws BookOrderException;
	public BookOrder viewBookOrder(int orderId) throws BookOrderException;
	public List<BookOrder> listAll() throws BookOrderException;
	public BookOrder updatebookOrder(BookOrder bo) throws BookOrderException;
}
