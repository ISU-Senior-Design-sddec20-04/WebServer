package com.sisyphusWeb.webService.payload;

import com.sisyphusWeb.webService.model.table.Track;

public class QueueItemResponse {
		
	private long id;
		
	private Track track;
		
	private boolean sendClear;
	
	public QueueItemResponse() {
		
	}
	
	public QueueItemResponse(long id, Track track, boolean sendClear) {
		this.id = id;
		this.track = track;
		this.sendClear = sendClear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public boolean isSendClear() {
		return sendClear;
	}

	public void setSendClear(boolean sendClear) {
		this.sendClear = sendClear;
	}
}
