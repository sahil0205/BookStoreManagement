package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer>{
	
}
