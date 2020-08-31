package com.mercadolibre.solarSystem.geometry;

public class Line {

	private Point point1;
	private Point point2;
	
	/** A Line on the space.
	*
	*  @constructor create a new Line using two Points on the space.
	*  @param p1 point on the space.
	*  @param p2 another point on the space.
	*/
	
	public Line(Point p1, Point p2) {
		point1 = p1;
		point2 = p2;
	}
	
	
	
	public Point getPoint1() {
		return point1;
	}



	public void setPoint1(Point point1) {
		this.point1 = point1;
	}



	public Point getPoint2() {
		return point2;
	}



	public void setPoint2(Point point2) {
		this.point2 = point2;
	}



	/** Checks if a Point is in the line
	  *
	  *  @param point p on the space.
	  *  @return true if it is part of line, false it is not
	  *
	  */
	public boolean isInLine(Point p) {
		
		// Check added for cases where the alignment occurs in one of the axis. Math logic failing due to 0 value in operations
		if(p.getX().equals(point1.getX()) && p.getX().equals(point2.getX())) {
			return true;
		}
		if(p.getY().equals(point1.getY()) && p.getY().equals(point2.getY())) {
			return true;
		}
//		(x-x1)/(x2-x1) = (y-y1)/(y2-y1)
		return (p.getX() - point1.getX()) / (point2.getX() - point1.getX()) == (p.getY()-point1.getY()) / (point2.getY()-point1.getY());

	}

	/** Distance between the two points
	  *
	  *  @return the distance between the two points as a Double
	  */
	public Double distance(){
	  return Math.sqrt((Math.pow(point2.getX() - point1.getX(),2) + Math.pow(point2.getY() - point1.getY(), 2)));
	}
}


