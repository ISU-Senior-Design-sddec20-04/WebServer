package com.sisyphusWeb.webService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisyphusWeb.webService.model.User;
import com.sisyphusWeb.webService.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public User returnUser(String name) {
		return userRepo.findByName(name);
	}
	
	public void updatePassword(String name, String password) {
		User user = userRepo.findByName(name);
		user.setPassword(password);
		userRepo.save(user);
	}
	
	public void updateUsername(String name, String newName) {
		User user = userRepo.findByName(name);
		user.setName(newName);
		userRepo.save(user);
	}
	
	public boolean exists(String name) {
		return userRepo.existsByName(name);
	}
	
	
}
