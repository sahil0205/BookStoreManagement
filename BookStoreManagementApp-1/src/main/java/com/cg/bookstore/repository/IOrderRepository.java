package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer>{
	public boolean existsByDetailId(int detailId);
	
	public List<OrderDetails> findByBook(Book book); 
}
