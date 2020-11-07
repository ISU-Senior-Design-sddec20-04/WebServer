package com.sisyphusWeb.webService.model.table;

public class Coordinate {
	float x;
	
	float y;

	public Coordinate() {
		
	}
	
	public Coordinate(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
