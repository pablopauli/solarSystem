package com.mercadolibre.solarSystem.simulation.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.mercadolibre.solarSystem.simulation.Line;
import com.mercadolibre.solarSystem.simulation.Point;

public class LineTest {

	@Test
	public void isInLineTest() {
		
		Point p1 = new Point(2.0,3.0);
		Point p2 = new Point(6.0,5.0);
		Point p3 = new Point(4.0,4.0);
		
		Line line = new Line(p1,p2);
		
		boolean result = line.isInLine(p3);
		
		assertTrue(result);
	}
	
	@Test
	public void notInLineTest() {
		
		Point p1 = new Point(2.0,3.0);
		Point p2 = new Point(6.0,5.0);
		Point p3 = new Point(3.0,3.0);
		
		Line line = new Line(p1,p2);
		
		boolean result = line.isInLine(p3);
		
		assertFalse(result);
	}
}
