package com.mercadolibre.solarSystem.simulation.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.mercadolibre.solarSystem.simulation.Angle;

public class AngleTest {

	
	
	@Test
	public void addTest() {
		Angle angle1 = new Angle(90.0);
		Angle angle2 = new Angle(110.0);
		
		Angle resultAngle = angle1.add(angle2);
		
		assertEquals((double) resultAngle.getDegree(), 200.0);
		
		
		angle1 = new Angle(290.0);
		angle2 = new Angle(110.0);
		
		resultAngle = angle1.add(angle2);
		
		assertEquals((double) resultAngle.getDegree(), 40.0);
	
	}
	
	@Test
	public void subtractTest() {
		
		Angle angle1 = new Angle(90.0);
		Angle angle2 = new Angle(110.0);
		
		Angle resultAngle = angle1.subtract(angle2);
		
		assertEquals((double) resultAngle.getDegree(), 340.0);
		
		
		angle1 = new Angle(290.0);
		angle2 = new Angle(110.0);
		
		resultAngle = angle1.subtract(angle2);
		
		assertEquals((double) resultAngle.getDegree(), 180.0);
	}
	
	@Test
	public void multiplyTest() {
		Angle angle = new Angle(90.0);
		
		Angle resultAngle = angle.multiply(3);
		
		assertEquals((double) resultAngle.getDegree(), 270.0);
		

		resultAngle = angle.multiply(5);
		
		assertEquals((double) resultAngle.getDegree(), 90.0);
	}
	
	@Test
	public void equalsTest() {
		Angle angle1 = new Angle(90.0);
		Angle angle2 = new Angle(110.0);
		
		Angle angle3 = new Angle(110.0);
		
		
		assertFalse(angle1.equals(angle2));
		
		assertTrue(angle2.equals(angle3));

	}
	
	
}
