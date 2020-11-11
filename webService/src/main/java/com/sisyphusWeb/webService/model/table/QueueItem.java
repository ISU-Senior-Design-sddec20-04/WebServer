package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QueueItem {
	
	@Id
	private long id;
	
//	@OneToOne
	private String trackId;
	
	private boolean sendClear;
	
	public QueueItem() {
		
	}
	
	public QueueItem(long index, String trackId, boolean sendClear) {
		this.id = index;
		this.trackId = trackId;
		this.sendClear = sendClear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrack() {
		return trackId;
	}

	public void setTrack(String track) {
		this.trackId = track;
	}

	public boolean isSendClear() {
		return sendClear;
	}

	public void setSendClear(boolean sendClear) {
		this.sendClear = sendClear;
	}
}
