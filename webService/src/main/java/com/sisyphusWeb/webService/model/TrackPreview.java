package com.sisyphusWeb.webService.model;

//@Entity
public class TrackPreview {
//	@Id
	String id;
	
	String preview;
	
	public TrackPreview() {
		
	}
	
	public TrackPreview(String id, String preview) {
		this.id = id;
		this.preview = preview;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}
}
