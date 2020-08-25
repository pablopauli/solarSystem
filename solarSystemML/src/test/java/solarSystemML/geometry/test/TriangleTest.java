package solarSystemML.geometry.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import solarSystemML.geometry.Point;
import solarSystemML.geometry.Triangle;

public class TriangleTest {

	
	@Test
	public void isInLineTest() {
		
		Point p1 = new Point(0.0,0.0);
		Point p2 = new Point(5.0,0.0);
		Point p3 = new Point(2.5,5.0);
		
		Point p4 = new Point(2.0,1.0);
		
		Triangle t = new Triangle(p1,p2,p3);
		
		boolean result = t.isInTriangle(p4);
		
		assertTrue(result);
	}
}
