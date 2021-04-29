package com.cg.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.BookOrder;

@Repository
public interface IBookOrderRepository extends JpaRepository<BookOrder, Integer>{
	public boolean existsByOrderId(int orderId);
	public BookOrder findByOrderId(int orderId);
}
