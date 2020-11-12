package com.sisyphusWeb.webService.controller;

import java.util.ArrayList;

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
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		userService.addUser(user);
		return "Saved";
	}
	
	@GetMapping(path="/getAllUsers")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/getUser")
	public User getUser(@RequestParam int id) {
		User user = userService.getUser(id);
		return user;
	}
	
	@GetMapping("/getUserFavorites")
	public ArrayList<String> getUserFavorites(@RequestParam int id) {
		return userService.getUserFavorites(id);
	}
	
	@PutMapping(path="/updateUserPassword")
	public String updateUserPassword(@RequestParam int id, @RequestParam String password) {
		userService.updatePassword(id, password);
		return "Passowrd updated";
	}
	
	@PutMapping(path="/updateUsername")
	public String updateUserName(@RequestParam int id, @RequestParam String newName) {
		userService.updateUsername(id, newName);
		return "User: " + id + " updated to " + newName;
	}
	
	@PutMapping("/addTrackToFavorites")
	public void addToUserFavorite(@RequestParam int id, @RequestParam String trackId) {
		userService.addFavoritedTrack(id, trackId);
	}
	
	@PutMapping("/removeTrackFromFavorites") 
	public void removeFromUserFavorites(@RequestParam int id, @RequestParam String trackId) {
		userService.removeFavoritedTrack(id, trackId);
	}
}
