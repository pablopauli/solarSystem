package com.mercadolibre.solarSystem.simulation.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mercadolibre.solarSystem.simulation.Angle;
import com.mercadolibre.solarSystem.simulation.Planet;
import com.mercadolibre.solarSystem.simulation.Point;

public class PlanetTest {

	
	
	@Test
	public void moveXdaysTest() {
		
		Planet planet = new Planet(new Point(10.0,0.0), 10.0, new Angle(0.0), new Angle(90.0), false);
		
		planet.moveXDays(1);
		
		assertTrue(planet.getAngle().equals(new Angle(90.0)));
		
		planet.moveXDays(1);
		
		assertTrue(!planet.getAngle().equals(new Angle(90.0)));
	}
	

}
