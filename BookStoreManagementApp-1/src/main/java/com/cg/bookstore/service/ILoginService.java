package com.cg.bookstore.service;

import com.cg.bookstore.entities.User;
import com.cg.bookstore.exceptions.UserException;

public interface ILoginService {

	public User addUser(User user) throws UserException;
	public void removeUser(int userId) throws UserException;
	public boolean validateUser(String email, String password) throws UserException;
}
