package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
	@Id
	private String id;
	
	private int vel;
	
	private float accel;
	
	private int thvmax;
	
	private int firstR;
	
	private int lastR;
	
	private String name;
	
	private int _index;
	
	private int start;
	
	private boolean reversed;
	
	private boolean reversible;

	public Track() {
		
	}
	
	public Track(String id, int vel, float accel, int thvmax, int firstR, int lastR, String name, int _index, int start,
			boolean reversed, boolean reversible) {
		this.id = id;
		this.vel = vel;
		this.accel = accel;
		this.thvmax = thvmax;
		this.firstR = firstR;
		this.lastR = lastR;
		this.name = name;
		this._index = _index;
		this.start = start;
		this.reversed = reversed;
		this.reversible = reversible;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getVel() {
		return vel;
	}
	
	public void setVel(int vel) {
		this.vel = vel;
	}
	
	public float getAccel() {
		return accel;
	}
	
	public void setAccel(float accel) {
		this.accel = accel;
	}
	
	public int getThvmax() {
		return thvmax;
	}
	
	public void setThvmax(int thvmax) {
		this.thvmax = thvmax;
	}
	
	public int getFirstR() {
		return firstR;
	}
	public void setFirstR(int firstR) {
		this.firstR = firstR;
	}
	
	public int getLastR() {
		return lastR;
	}
	
	public void setLastR(int lastR) {
		this.lastR = lastR;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int get_index() {
		return _index;
	}
	
	public void set_index(int _index) {
		this._index = _index;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public boolean isReversed() {
		return reversed;
	}
	
	public void setReversed(boolean reversed) {
		this.reversed = reversed;
	}
	
	public boolean isReversible() {
		return reversible;
	}
	
	public void setReversible(boolean reversible) {
		this.reversible = reversible;
	}
}
