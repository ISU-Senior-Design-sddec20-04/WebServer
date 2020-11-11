package com.sisyphusWeb.webService.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisyphusWeb.webService.model.User;
import com.sisyphusWeb.webService.repository.TrackRepository;
import com.sisyphusWeb.webService.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TrackRepository trackRepo;
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public User getUser(String name) {
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
	
	public void addTrack(String name, String id) {
		User user = userRepo.findByName(name);
		ArrayList<String> tracks = user.getUploadedTracks();
		tracks.add(id);
		user.setUploadedTracks(tracks);
		userRepo.save(user);
	}
	
	public void addFavoritedTrack(String name, String id) {
		User user = userRepo.findByName(name);
		ArrayList<String> tracks = user.getFavoriteTracks();
		tracks.add(id);
		user.setFavoriteTracks(tracks);
		userRepo.save(user);
	}
	
	public void removeFavoritedTrack(String name, String id) {
		User user = userRepo.findByName(name);
		ArrayList<String> tracks = user.getFavoriteTracks();
		tracks.remove(trackRepo.findById(id).get().getId());
		user.setFavoriteTracks(tracks);
		userRepo.save(user);
	}
}
