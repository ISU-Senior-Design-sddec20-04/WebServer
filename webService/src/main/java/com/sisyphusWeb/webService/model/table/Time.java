package com.sisyphusWeb.webService.model.table;

public class Time {
	private int remaining_time;
	
	private int total_time;
	
	public Time() {
		
	}
	
	public Time(int remaining_time, int total_time) {
		this.remaining_time = remaining_time;
		this.total_time = total_time;
	}

	public int getRemaining_time() {
		return remaining_time;
	}

	public void setRemaining_time(int remaining_time) {
		this.remaining_time = remaining_time;
	}

	public int getTotal_time() {
		return total_time;
	}

	public void setTotal_time(int total_time) {
		this.total_time = total_time;
	}
}
