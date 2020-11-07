package com.sisyphusWeb.webService.model.table;

import javax.persistence.OneToOne;

public class Play {

	private String id;
	
	private boolean is_waiting_between_tracks;
	
	private String state;
	
	@OneToOne
	private Track active_track;
	
	public Play() {
		
	}

	public Play(String id, boolean is_waiting_between_tracks, String state, Track active_track) {
		this.id = id;
		this.is_waiting_between_tracks = is_waiting_between_tracks;
		this.state = state;
		this.active_track = active_track;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isIs_waiting_between_tracks() {
		return is_waiting_between_tracks;
	}

	public void setIs_waiting_between_tracks(boolean is_waiting_between_tracks) {
		this.is_waiting_between_tracks = is_waiting_between_tracks;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Track getActive_track() {
		return active_track;
	}

	public void setActive_track(Track active_track) {
		this.active_track = active_track;
	}
}
