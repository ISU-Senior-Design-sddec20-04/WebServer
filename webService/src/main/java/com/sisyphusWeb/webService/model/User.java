package com.sisyphusWeb.webService.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	private String name;
	
	private String password;
	
	private ArrayList<String> favoriteTracks;
	
	private ArrayList<String> uploadedTracks;
	
	public User() {
		this.name = "";
		this.password = "";
		this.favoriteTracks = new ArrayList<>();
		this.uploadedTracks = new ArrayList<>();
	}
	
	public User(String name, String password, ArrayList<String> favoriteTracks, ArrayList<String> uploadedTracks) {
		this.name = name;
		this.password = password;
		this.favoriteTracks = favoriteTracks;
		this.uploadedTracks = uploadedTracks;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getFavoriteTracks() {
		return favoriteTracks;
	}

	public void setFavoriteTracks(ArrayList<String> favoriteTracks) {
		this.favoriteTracks = favoriteTracks;
	}

	public ArrayList<String> getUploadedTracks() {
		return uploadedTracks;
	}

	public void setUploadedTracks(ArrayList<String> uploadedTracks) {
		this.uploadedTracks = uploadedTracks;
	}
}
