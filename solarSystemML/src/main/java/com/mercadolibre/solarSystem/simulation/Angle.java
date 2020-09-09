package com.mercadolibre.solarSystem.simulation;

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
    *  @param angle another Angle to add
    *  @return a new Angle
    */
	public Angle add(Angle angle) {
		Double result = this.getDegree() + angle.getDegree();
		if(result < 360) {
			return new Angle(result);
		}
		
		return new Angle(result%360);
	}
	
	

	  /** Subtracting angles.
	    *
	    *  @param angle another Angle to subtract
	    *  @return a new Angle
	    */
	public Angle subtract(Angle angle) {
		Double result = this.getDegree() - angle.getDegree();
		if(result >= 0) {
			return new Angle(result);
		}
		
		return new Angle(result + 360);
	}
	

	  /** Multiplying the angle n times.
	    *
	    *  @param n a number
	    *  @return a new Angle
	    */
	public Angle multiply(int n) {
		return new Angle(this.getDegree() * n % 360);
	}
	

	  /** Equals method.
	    *
	    *  @param angle another Angle
	    *  @return boolean true if equals, false if not
	    */
	public boolean equals(Angle angle) {
		return this.getDegree() == angle.getDegree();
	}
	

	  /** Return a Point depending of its distance to Point(0,0) and the angle.
	    *
	    *  @param distance number representing the distance to Point(0, 0)
	    *  @return a new Point
	    */
	public Point toPoint(Double distance) {
		Double x = Math.cos(Math.toRadians(this.getDegree())) * distance;
		
		double roundOffX = Math.round(x * 100.0) / 100.0;
		
		Double y = Math.sin(Math.toRadians(this.getDegree())) * distance;
		
		double roundOffY = Math.round(y * 100.0) / 100.0;
		
		return new Point(roundOffX,roundOffY);
	}

	
}
