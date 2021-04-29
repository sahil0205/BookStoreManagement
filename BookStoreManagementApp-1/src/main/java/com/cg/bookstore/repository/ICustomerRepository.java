package com.cg.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	public boolean existsByCustomerId(int customerId);
	public boolean existsByFullName(String fullName);
	public Customer findByCustomerId(int customerId);
	public Customer findByFullName(String fullName);
}
