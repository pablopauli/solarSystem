package com.mercadolibre.solarSystem.weather.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolibre.solarSystem.entities.Planet;
import com.mercadolibre.solarSystem.entities.SolarSystem;
import com.mercadolibre.solarSystem.geometry.Point;
import com.mercadolibre.solarSystem.service.WeatherConditions;

public class WeatherConditionsTest {

	@Autowired
	private WeatherConditions weatherConditions;
	
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
		
		List<Planet> planets = new ArrayList<Planet>();
		planets.add(planet1);
		planets.add(planet2);
		planets.add(planet3);
		SolarSystem s = new SolarSystem(planets );
		
		
		
		return s;
	}
}
