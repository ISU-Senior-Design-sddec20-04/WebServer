package com.sisyphusWeb.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.User;
import com.sisyphusWeb.webService.repository.UserRepository;
import com.sisyphusWeb.webService.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/addUser")
	public String addNewUser(@RequestParam String name, @RequestParam String password) {
		if(userService.exists(name)) {
			return "Username: " + name + " is taken. Please choose a different one";
		} else {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			userService.addUser(user);
			return "Saved";
		}
	}
	
	@GetMapping(path="/getAllUsers")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/getUser")
	public User getUser(@RequestParam String name) {
		User user = userService.getUser(name);
		return user;
	}
	
	@PutMapping(path="/updateUserPassword")
	public String updateUserPassword(@RequestParam String name, @RequestParam String password) {
		userService.updatePassword(name, password);
		return "Passowrd updated";
	}
	
	@PutMapping(path="/updateUsername")
	public String updateUserName(@RequestParam String name, @RequestParam String newName) {
		userService.updateUsername(name, newName);
		return "User: " + name + " updated to " + newName;
	}
}
