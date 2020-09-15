package com.mercadolibre.solarSystem.weather.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.mercadolibre.solarSystem.service.WeatherConditions;
import com.mercadolibre.solarSystem.simulation.Planet;
import com.mercadolibre.solarSystem.simulation.Point;
import com.mercadolibre.solarSystem.simulation.SolarSystem;


public class WeatherConditionsTest {

	
	private WeatherConditions weatherConditions = new WeatherConditions();
	

	
	@Test
	public void isDroughtTest() {
		
		SolarSystem s = createSolarSystem(new Point(1.0,1.0), new Point(2.0,2.0), new Point(3.0,3.0));

		
		boolean result = weatherConditions.isDrought(s);
		
		assertTrue(result);
	}
	
	@Test
	public void notDroughtTest() {
		
		SolarSystem s = createSolarSystem(new Point(1.0,1.0), new Point(2.0,2.0), new Point(8.0,3.0));
		
		boolean result = weatherConditions.isDrought(s);
		
		assertFalse(result);
	}
	
	@Test
	public void isRainyTest() {
		
		SolarSystem s = createSolarSystem(new Point(-1.0,-1.0), new Point(-1.0,5.0), new Point(8.0,0.0));
		
		boolean result = weatherConditions.isRainy(s);
		
		assertTrue(result);
	}
	
	@Test
	public void notRainyTest() {
		
		SolarSystem s = createSolarSystem(new Point(-1.0,-1.0), new Point(-1.0,5.0), new Point(-8.0,-3.0));
		
		boolean result = weatherConditions.isRainy(s);
		
		assertFalse(result);
	}
	
	
	@Test
	public void isOptimumTest() {
		
		SolarSystem s = createSolarSystem( new Point(-3.0,-4.0),new Point(-1.0,-2.0), new Point(5.0,4.0));
		
		
		
		boolean result = weatherConditions.isOptimum(s);
		
		assertTrue(result);
	}
	
	@Test
	public void notOptimumDueToSunTest() {
		
		SolarSystem s = createSolarSystem(new Point(0.0,-1.0), new Point(0.0,5.0), new Point(0.0,-3.0));
		

		boolean result = weatherConditions.isOptimum(s);
		
		assertFalse(result);
	}
	
	@Test
	public void notOptimumTest() {
		
		SolarSystem s = createSolarSystem(new Point(-1.0,-1.0), new Point(-1.0,5.0), new Point(-2.0,-3.0));
		
	
		
		boolean result = weatherConditions.isOptimum(s);
		
		assertFalse(result);
	}
	
	
	private SolarSystem createSolarSystem(Point p1, Point p2, Point p3) {
		
		// Only position is relevant for these tests
		Planet planet1 = new Planet(p1, null, null, null, true);
		Planet planet2 = new Planet(p2, null, null, null, true);
		Planet planet3 = new Planet(p3, null, null, null, true);
		
		
		SolarSystem solarSystem = new SolarSystem(planet1, planet2, planet3);
		
		
		
		return solarSystem;
	}
}
