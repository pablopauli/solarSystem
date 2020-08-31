package com.mercadolibre.solarSystem.geometry;

public class Angle {

	private Double degree;
	
	public Angle(Double degree) {
		this.degree = degree;
	}
	
	
	
	public Double getDegree() {
		return degree;
	}



	public void setDegree(Double degree) {
		this.degree = degree;
	}


	/** Adding angles.
    *
    *  @param angle another Angle
    */
	public Angle add(Angle a) {
		Double result = this.getDegree() + a.getDegree();
		if(result < 360) {
			return new Angle(result);
		}
		
		return new Angle(result%360);
	}
	
	

	  /** Subtracting angles.
	    *
	    *  @param angle another Angle
	    */
	public Angle subtract(Angle a) {
		Double result = this.getDegree() - a.getDegree();
		if(result >= 0) {
			return new Angle(result);
		}
		
		return new Angle(result + 360);
	}
	

	  /** Multiplying the angle .
	    *
	    *  @param n a number
	    */
	public Angle multiply(int n) {
		return new Angle(this.getDegree() * n % 360);
	}
	

	  /** Equals method.
	    *
	    *  @param angle another Angle
	    */
	public boolean equals(Angle a) {
		return this.getDegree() == a.getDegree();
	}
	

	  /** Return a Point depending of its distance to Point(0,0) and the angle.
	    *
	    *  @param distance number representing the distance to Point(0, 0)
	    */
	public Point toPoint(Double distance) {
		Double x = Math.cos(Math.toRadians(this.getDegree())) * distance;
		
		double roundOffX = Math.round(x * 100.0) / 100.0;
		
		Double y = Math.sin(Math.toRadians(this.getDegree())) * distance;
		
		double roundOffY = Math.round(y * 100.0) / 100.0;
		
		return new Point(roundOffX,roundOffY);
	}

	
}
