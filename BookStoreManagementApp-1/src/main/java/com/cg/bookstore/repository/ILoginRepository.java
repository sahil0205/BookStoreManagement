package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.User;

@Repository
public interface ILoginRepository extends JpaRepository<User, Integer>{
	public boolean existsByEmail(String email);
	public boolean existsByEmailAndPassword(String email, String password);
	public boolean existsByUserId(int userId);
}
