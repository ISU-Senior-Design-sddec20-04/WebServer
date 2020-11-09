package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Queue {
	
	@Id
	private int id;
	
	@OneToOne
	private Track track;
	
	public Queue() {
		
	}
	
	public Queue(int id, Track track) {
		this.id = id;
		this.track = track;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
}
