package solarSystemML.entities;

import solarSystemML.geometry.Angle;
import solarSystemML.geometry.Point;

public class Planet {

	private Point position;
	private Double distance;
	private Angle angle;
	private Angle angularSpeed;
	private boolean clockwiseRotation;
	
	
	/** 
	  *
	  *  @constructor create a new Planet.
	  *  @param position a Point(x,y), representing the position of the object in the space
	  *  @param distance a number representing the distance of the planet to the sun.
	  *  @param angle an Angle(z) representing the angle formed with the x-axis.
	  *  @param angularSpeed Angle(x) that the object moves every day.
	  *  @param clockwiseRotation boolean that indicates rotation
	  */
	public Planet(Point position, Double distance, Angle angle, Angle angularSpeed, boolean clockwiseRotation) {
		this.position = position;
		this.distance = distance;
		this.angle = angle;
		this.angularSpeed = angularSpeed;
		this.clockwiseRotation = clockwiseRotation;
	}

	public void moveXDays(int days) {
		if(isClockwiseRotation()) {
			setAngle(getAngle().subtract(getAngularSpeed().multiply(days)));
		}else {
			setAngle(getAngle().add(getAngularSpeed().multiply(days)));
		}
	}
	

	public void resetPosition() {
		setAngle(new Angle(90.0));
		setPosition(new Point(0.0, getDistance()));
	}


	public Point getPosition() {
		return position;
	}


	public void setPosition(Point position) {
		this.position = position;
	}


	public Double getDistance() {
		return distance;
	}


	public void setDistance(Double distance) {
		this.distance = distance;
	}


	public Angle getAngle() {
		return angle;
	}


	public void setAngle(Angle angle) {
		this.angle = angle;
	}


	public Angle getAngularSpeed() {
		return angularSpeed;
	}


	public void setAngularSpeed(Angle angularSpeed) {
		this.angularSpeed = angularSpeed;
	}


	public boolean isClockwiseRotation() {
		return clockwiseRotation;
	}


	public void setClockwiseRotation(boolean clockwiseRotation) {
		this.clockwiseRotation = clockwiseRotation;
	}
	
	
}
