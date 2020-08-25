package solarSystemML.geometry.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import solarSystemML.geometry.Line;
import solarSystemML.geometry.Point;

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
}
