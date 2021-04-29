package com.cg.bookstore.service;

import java.util.List;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.entities.OrderDetails;
import com.cg.bookstore.exceptions.OrderException;

public interface IOrderService {

	public List<OrderDetails> listAllOrders() throws OrderException;
	public List<OrderDetails> listOrderByCustomer(Customer cs) throws OrderException;
	public OrderDetails viewOrderForCustomer(OrderDetails od) throws OrderException;
	public OrderDetails viewOrderForAdmin(OrderDetails od) throws OrderException;
	public void cancelOrder(int detailId) throws OrderException;
	public OrderDetails addOrder(OrderDetails od) throws OrderException;
	public OrderDetails updateOrder(OrderDetails od) throws OrderException;
	public List<OrderDetails> viewOrderByBook(String title) throws OrderException;
	public List<Book> listBestSellingBook() throws OrderException;

}
