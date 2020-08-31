package com.mercadolibre.solarSystem.geometry.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.mercadolibre.solarSystem.geometry.Point;
import com.mercadolibre.solarSystem.geometry.Triangle;

public class TriangleTest {

	
	@Test
	public void isInTriangleTest() {
		
		Point p1 = new Point(0.0,0.0);
		Point p2 = new Point(5.0,0.0);
		Point p3 = new Point(2.5,5.0);
		
		Point p4 = new Point(2.0,1.0);
		
		Triangle t = new Triangle(p1,p2,p3);
		
		boolean result = t.isInTriangle(p4);
		
		assertTrue(result);
	}
	
	@Test
	public void notInTriangleTest() {
		
		Point p1 = new Point(0.0,0.0);
		Point p2 = new Point(5.0,0.0);
		Point p3 = new Point(2.5,5.0);
		
		Point p4 = new Point(7.0,7.0);
		
		Triangle t = new Triangle(p1,p2,p3);
		
		boolean result = t.isInTriangle(p4);
		
		assertFalse(result);
	}
}
