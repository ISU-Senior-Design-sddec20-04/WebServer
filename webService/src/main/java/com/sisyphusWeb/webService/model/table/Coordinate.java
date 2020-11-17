package com.sisyphusWeb.webService.model.table;

import java.io.Serializable;

public class Coordinate implements Serializable{
	float rho;
	
	float theta;

	public Coordinate() {
		
	}
	
	public Coordinate(float theta, float rho) {
		this.theta = theta;
		this.rho = rho;
	}

	public float getRho() {
		return rho;
	}

	public void setRho(float rho) {
		this.rho = rho;
	}

	public float getTheta() {
		return theta;
	}

	public void setTheta(float theta) {
		this.theta = theta;
	}
}
