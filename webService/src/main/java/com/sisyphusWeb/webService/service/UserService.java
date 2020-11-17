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
	
	public User getUser(int id) {
		return userRepo.findById(id).get();
	}
	
	public ArrayList<String> getUserFavorites(int id) {
		return userRepo.findById(id).get().getFavoriteTracks();
	}
	
	public void updatePassword(int id, String password) {
		User user = userRepo.findById(id).get();
		user.setPassword(password);
		userRepo.save(user);
	}
	
	public void updateUsername(int id, String newName) {
		User user = userRepo.findById(id).get();
		user.setName(newName);
		userRepo.save(user);
	}
	
	public boolean exists(int id) {
		return userRepo.existsById(id);
	}
	
	public void addTrack(int id, String trackId) {
		User user = userRepo.findById(id).get();
		ArrayList<String> tracks = user.getUploadedTracks();
		tracks.add(trackId);
		user.setUploadedTracks(tracks);
		userRepo.save(user);
	}
	
	public void addFavoritedTrack(int id, String trackId) {
		User user = userRepo.findById(id).get();
		ArrayList<String> tracks = user.getFavoriteTracks();
		tracks.add(trackId);
		user.setFavoriteTracks(tracks);
		userRepo.save(user);
	}
	
	public void removeFavoritedTrack(int id, String trackId) {
		User user = userRepo.findById(id).get();
		ArrayList<String> tracks = user.getFavoriteTracks();
		tracks.remove(trackRepo.findById(trackId).get().getId());
		user.setFavoriteTracks(tracks);
		userRepo.save(user);
	}
}
