package com.mercadolibre.solarSystem.simulation;

public class Point {

	private Double x;
	private Double y;
	
	
	/** A Point on the space.
	  *
	  *  @param x position in the x-axis
	  *  @param y position in the x-axis
	  */
	public Point(Double x,Double y) {
		this.x = x;
		this.y = y;
	}


	public Double getX() {
		return x;
	}


	public void setX(Double x) {
		this.x = x;
	}


	public Double getY() {
		return y;
	}


	public void setY(Double y) {
		this.y = y;
	}
	
	
}
