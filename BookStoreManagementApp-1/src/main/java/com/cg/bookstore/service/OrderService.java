package com.cg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.entities.OrderDetails;
import com.cg.bookstore.exceptions.OrderException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.IOrderRepository;

@Service
@Transactional
public class OrderService implements IOrderService{
	
	@Autowired
	IOrderRepository repository;
	
	@Autowired
	IBookRepository bookRepo;

	@Override
	public List<OrderDetails> listAllOrders() throws OrderException {
		List<OrderDetails> orderList = repository.findAll();
		if(orderList.isEmpty())
			throw new OrderException("No Data found");
		else
			return orderList;
	}

	@Override
	public List<OrderDetails> listOrderByCustomer(Customer cs) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails viewOrderForCustomer(OrderDetails od) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails viewOrderForAdmin(OrderDetails od) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelOrder(int detailId) throws OrderException {
		if(repository.existsByDetailId(detailId))
			repository.deleteById(detailId);
		else
			throw new OrderException("Order doesn't exists");
	}

	@Override
	public OrderDetails addOrder(OrderDetails od) throws OrderException {
		if(repository.existsByDetailId(od.getDetailId()))
			throw new OrderException("Order already exists");
		else
			return repository.save(od);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails od) throws OrderException {
		if(repository.existsByDetailId(od.getDetailId()))
			return repository.save(od);
		else
			throw new OrderException("Order doesn't exists");
	}

	@Override
	public List<OrderDetails> viewOrderByBook(String title) throws OrderException {
		Book bookData = bookRepo.findByTitle(title);
		List<OrderDetails> orderList = repository.findByBook(bookData);
		return orderList;
	}

	@Override
	public List<Book> listBestSellingBook() throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
