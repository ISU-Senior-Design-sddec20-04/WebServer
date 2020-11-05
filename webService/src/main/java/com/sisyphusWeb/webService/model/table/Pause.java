package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pause {
	@Id
	private String err;
	
	@OneToOne
	private PauseResponse resp;
	
	public Pause() {
		
	}
	
	public Pause(String err, PauseResponse resp) {
		this.err = err;
		this.resp = resp;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public PauseResponse getResp() {
		return resp;
	}

	public void setResp(PauseResponse resp) {
		this.resp = resp;
	}
}
