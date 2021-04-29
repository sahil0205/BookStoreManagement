package com.cg.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.exceptions.BookOrderException;
import com.cg.bookstore.repository.IBookOrderRepository;

@Service
@Transactional
public class BookOrderService implements IBookOrderService{

	@Autowired
	IBookOrderRepository repository;
	
	@Override
	public BookOrder addBookOrder(BookOrder bo) throws BookOrderException {
		if(repository.existsByOrderId(bo.getOrderId()))
			throw new BookOrderException("Order exists already");
		else
			return repository.save(bo);
	}

	@Override
	public void cancelBookOrder(int orderId) throws BookOrderException {
		if(!(repository.existsByOrderId(orderId)))
				throw new BookOrderException("Order does not exist");
		else
			repository.deleteById(orderId);
		
	}

	@Override
	public BookOrder viewBookOrder(int orderId) throws BookOrderException {
		if(!(repository.existsByOrderId(orderId)))
			throw new BookOrderException("Order does not exist");
		else
			return repository.findByOrderId(orderId);
	}

	@Override
	public List<BookOrder> listAll() throws BookOrderException {
		List<BookOrder> orderList = repository.findAll();
		if(orderList.isEmpty())
			throw new BookOrderException("No data found");
		else
			return orderList;
	}

	@Override
	public BookOrder updatebookOrder(BookOrder bo) throws BookOrderException {
		if(repository.existsByOrderId(bo.getOrderId()))
			return repository.save(bo);
		else
			throw new BookOrderException("Order does not exist");
	}

}
