package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Play {

	@Id
	private String err;
	
	@OneToOne
	private PlayResponse resp;
	
	public Play() {
		
	}

	public Play(String err, PlayResponse resp) {
		this.err = err;
		this.resp = resp;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public PlayResponse getResp() {
		return resp;
	}

	public void setResp(PlayResponse resp) {
		this.resp = resp;
	}
}
