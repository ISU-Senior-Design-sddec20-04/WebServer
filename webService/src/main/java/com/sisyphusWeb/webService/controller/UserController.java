package com.sisyphusWeb.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.User;
import com.sisyphusWeb.webService.repository.UserRepository;

@RestController
@RequestMapping(path="/demo")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/add")
	public String addNewUser(@RequestBody User user) {
		userRepository.save(user);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
