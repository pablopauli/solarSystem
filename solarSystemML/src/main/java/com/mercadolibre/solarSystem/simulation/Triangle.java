package com.mercadolibre.solarSystem.simulation;

public class Triangle {

	private Point p1;
	private Point p2;
	private Point p3;
	
	
	/** Creates a Triangle using three Points on the space as vertices.
	*
	*  @param p1 point on the space.
	*  @param p2 another point on the space.
	*  @param p3 another point on the space.
	*/
	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	

	public Point getP1() {
		return p1;
	}



	public void setP1(Point p1) {
		this.p1 = p1;
	}



	public Point getP2() {
		return p2;
	}



	public void setP2(Point p2) {
		this.p2 = p2;
	}



	public Point getP3() {
		return p3;
	}



	public void setP3(Point p3) {
		this.p3 = p3;
	}



	/** To calculate the perimeter of the triangle
	  *
	  *  @return the perimeter as a Double
	  */
	public Double perimeter() {
		Line l1 = new Line(p1,p2);
		Line l2 = new Line(p1,p3);
		Line l3 = new Line(p2,p3);
		
		return l1.distance() + l2.distance() + l3.distance();
	}
	
	/** Checks if a Point is inside the triangle
	  *
	  *  @param point a Point on the space.
	  *  @return true if it is inside the triangle, false it is not
	  *
	  */
	public boolean isInTriangle(Point point) {
		Triangle t1 = new Triangle(p1, p2, point);
		Triangle t2 = new Triangle(p2, p3, point);
		Triangle t3 = new Triangle(p3, p1, point);
		
		boolean negative;
		boolean positive;
		
		Double sign1 = sign(t1);
		Double sign2 = sign(t2);
		Double sign3 = sign(t3);
		
		
		negative = (sign1 < 0) || (sign2 < 0) || (sign3 < 0);
	    positive = (sign1 > 0) || (sign2 > 0) || (sign3 > 0);

	    return !(negative && positive);
		
		
	}
	
	/** Sign of another triangle
	  *
	  *  @return true if it is positive, false if negative
	  */
	private Double sign(Triangle t) {
		return (((t.getP1().getX() - t.getP3().getX()) * (t.getP2().getY() - t.getP3().getY())) -
			    ((t.getP1().getY() - t.getP3().getY()) * (t.getP2().getX() - t.getP3().getX())));
	}
}



