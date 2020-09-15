package com.mercadolibre.solarSystem.utils.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import com.mercadolibre.solarSystem.simulation.SolarSystem;
import com.mercadolibre.solarSystem.utils.SolarSystemUtils;

public class SolarSystemUtilsTest {

	
	@Test
	public void generateSolarSystemTest() {
		
		
		SolarSystem solarSystem = SolarSystemUtils.generateMainSolarSystem();
		
		SolarSystem solarSystem2 = SolarSystemUtils.generateMainSolarSystem();
		
		assertTrue(solarSystem.getFerengi().getDistance().equals(solarSystem2.getFerengi().getDistance()));
		
		assertTrue(solarSystem.getPlanetsTrianglePerimeter().equals(solarSystem2.getPlanetsTrianglePerimeter()));
		
	}
}
