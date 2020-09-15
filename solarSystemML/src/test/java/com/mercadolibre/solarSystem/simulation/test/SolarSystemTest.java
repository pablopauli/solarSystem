package com.mercadolibre.solarSystem.simulation.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mercadolibre.solarSystem.simulation.Angle;
import com.mercadolibre.solarSystem.simulation.SolarSystem;
import com.mercadolibre.solarSystem.utils.SolarSystemUtils;

public class SolarSystemTest {

	
	@Test
	public void moveXdaysTest(){
		SolarSystem solarSystem = SolarSystemUtils.generateMainSolarSystem();
		
		//initial angle for each planet
		assertTrue(solarSystem.getBetasoide().getAngle().equals(new Angle(90.0)));
		assertTrue(solarSystem.getFerengi().getAngle().equals(new Angle(90.0)));
		assertTrue(solarSystem.getVulcano().getAngle().equals(new Angle(90.0)));
		
		solarSystem.moveXDays(1);
		
		// betasoide angular speed is 3° per day clockwise rotation => 90 - 3 = 87
		assertTrue(solarSystem.getBetasoide().getAngle().equals(new Angle(87.0)));
		
		// vulcano angular speed is 5° per day anti clockwise rotation => 90 + 5 = 95
		assertTrue(solarSystem.getVulcano().getAngle().equals(new Angle(95.0)));

		// ferengi angular speed is 1° per day clockwise rotation => 90 - 1 = 87
		assertTrue(solarSystem.getFerengi().getAngle().equals(new Angle(89.0)));
		
		
	}
	
	@Test
	public void perimeterTest() {
		
		SolarSystem solarSystem = SolarSystemUtils.generatePerimeterTestSolarSystem();
		// distance between betasoide and vulcano = 1000
		// distance between betasoide and ferengi = 707.106781
		// distance between vulcano and ferengi = 707.106781
		// 1000 + 707.106781 + 707.106781 = 2414.213562
		// rounded 3 dec units = 2414.214
		
		Double perimeter = solarSystem.getPlanetsTrianglePerimeter();
		
		assertTrue(perimeter.equals(2414.214));
		
	}
}
