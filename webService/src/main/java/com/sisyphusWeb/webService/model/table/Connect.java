package com.sisyphusWeb.webService.model.table;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Connect {

	@Id
	private String err;
	
	@OneToOne
	private List<ConnectResponse> resp;
	
	public Connect() {
		
	}

	public Connect(String err, List<ConnectResponse> resp) {
		this.err = err;
		this.resp = resp;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public List<ConnectResponse> getResp() {
		return resp;
	}

	public void setResp(List<ConnectResponse> resp) {
		this.resp = resp;
	}
}
