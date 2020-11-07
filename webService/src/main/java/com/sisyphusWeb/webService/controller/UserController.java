package com.sisyphusWeb.webService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sisyphusWeb.webService.model.User;
import com.sisyphusWeb.webService.repository.UserRepository;
import com.sisyphusWeb.webService.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/add")
	public String addNewUser(@RequestBody User user) {
		if(userService.exists(user.getName())) {
			return "Username: " + user.getName() + " is taken. Please choose a different one";
		} else {
			userService.addUser(user);
			return "Saved";
		}
	}
	
	@GetMapping(path="/all")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/{name}")
	public User getUser(@PathVariable String name) {
		return userService.returnUser(name);
	}
	
	@PutMapping(path="/{name}/updatePassword")
	public String updateUserPassword(@PathVariable String name, @RequestParam String password) {
		userService.updatePassword(name, password);
		return "Updated";
	}
	
	@PutMapping(path="/{name}/updateName")
	public String updateUserName(@PathVariable String name, @RequestParam String newName) {
		userService.updateUsername(name, newName);
		return "Updated";
	}
}
