package com.sisyphusWeb.webService.model.table;

public class BallPosition {
	double accum_th;
	
	double th;
	
	double r;
	
	BallPosition() {
		
	}

	public BallPosition(double accum_th, double th, double r) {
		this.accum_th = accum_th;
		this.th = th;
		this.r = r;
	}

	public double getAccum_th() {
		return accum_th;
	}

	public void setAccum_th(double accum_th) {
		this.accum_th = accum_th;
	}

	public double getTh() {
		return th;
	}

	public void setTh(double th) {
		this.th = th;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
}
