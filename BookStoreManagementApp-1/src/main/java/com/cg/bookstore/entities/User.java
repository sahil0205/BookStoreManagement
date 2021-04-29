package com.cg.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String email;
	private String password;
	private String role;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(int userId, String email, String password, String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
}
