package com.sisyphusWeb.webService.model;

import java.io.Serializable;

public class Post implements Serializable{
	
	private String data;
	
	public String getBody() {
		return data;
	}
	public void setBody(String body) {
		this.data = body;
	}
}
