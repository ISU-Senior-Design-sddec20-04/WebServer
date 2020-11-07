package com.sisyphusWeb.webService.model.table;

public class Pause {
	private String id;
	
	private String state;
	
	public Pause() {
		
	}
	
	public Pause(String id, String state) {
		this.id = id;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
