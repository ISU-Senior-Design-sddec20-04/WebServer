package com.sisyphusWeb.webService.model.table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;


public class Playlist {

	private String id;
	
	private String type;
	
	private String name;
	
	private boolean is_loop;
	
	private boolean is_shuffle;
	
	private int active_track_index;
	
	private String active_track_id;
	
	@OneToMany
	private ArrayList<Track> tracks;
	
	private int[] sorted_tracks;
	
	private int[] next_tracks;
	
	private String description;
	
	private String created_by_name;
	
	public Playlist() {
		
	}

	public Playlist(String id, String type, String name, boolean is_loop, boolean is_shuffle, int active_track_index,
			String active_track_id, ArrayList<Track> tracks, int[] sorted_tracks, int[] next_tracks, String description,
			String created_by_name) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.is_loop = is_loop;
		this.is_shuffle = is_shuffle;
		this.active_track_index = active_track_index;
		this.active_track_id = active_track_id;
		this.tracks = tracks;
		this.sorted_tracks = sorted_tracks;
		this.next_tracks = next_tracks;
		this.description = description;
		this.created_by_name = created_by_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIs_loop() {
		return is_loop;
	}

	public void setIs_loop(boolean is_loop) {
		this.is_loop = is_loop;
	}

	public boolean isIs_shuffle() {
		return is_shuffle;
	}

	public void setIs_shuffle(boolean is_shuffle) {
		this.is_shuffle = is_shuffle;
	}

	public int getActive_track_index() {
		return active_track_index;
	}

	public void setActive_track_index(int active_track_index) {
		this.active_track_index = active_track_index;
	}

	public String getActive_track_id() {
		return active_track_id;
	}

	public void setActive_track_id(String active_track_id) {
		this.active_track_id = active_track_id;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public int[] getSorted_tracks() {
		return sorted_tracks;
	}

	public void setSorted_tracks(int[] sorted_tracks) {
		this.sorted_tracks = sorted_tracks;
	}

	public int[] getNext_tracks() {
		return next_tracks;
	}

	public void setNext_tracks(int[] next_tracks) {
		this.next_tracks = next_tracks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_by_name() {
		return created_by_name;
	}

	public void setCreated_by_name(String created_by_name) {
		this.created_by_name = created_by_name;
	}
}
