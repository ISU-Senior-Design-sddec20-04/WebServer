package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StreamItem {

	@Id
	int id;
	
	String streamId;
	
	public StreamItem() {
		
	}
	
	public StreamItem(int id, String streamId) {
		this.id = id;
		this.streamId = streamId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
}
