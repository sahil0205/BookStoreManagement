package com.cg.bookstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.User;
import com.cg.bookstore.exceptions.UserException;
import com.cg.bookstore.repository.ILoginRepository;

@Service
@Transactional
public class LoginService implements ILoginService{

	@Autowired
	ILoginRepository repository;
	
	@Override
	public User addUser(User user) throws UserException {
		if(repository.existsByEmail(user.getEmail()))
			throw new UserException("User with "+user.getEmail()+" already exists");
		else {
			User userData = repository.save(user);
			return userData;
		}
	}

	@Override
	public void removeUser(int userId) throws UserException {
		// TODO Auto-generated method stub
		if(repository.existsByUserId(userId))
			repository.deleteById(userId);
		else
			throw new UserException("User not found");
	}

	@Override
	public boolean validateUser(String email, String password) throws UserException {
		if(repository.existsByEmailAndPassword(email, password))
			return true;
		else
			throw new UserException("Invalid Credentials");
	}

	

}
