package com.mercadolibre.solarSystem.utils;

import com.mercadolibre.solarSystem.simulation.Angle;
import com.mercadolibre.solarSystem.simulation.Planet;
import com.mercadolibre.solarSystem.simulation.Point;
import com.mercadolibre.solarSystem.simulation.SolarSystem;

public final class SolarSystemUtils {

	
	
	/**
	 * Returns a new SolarSystem
	 * 
	 * @return the SolarSystem use for the simulation
	 */
	public static SolarSystem generateMainSolarSystem() {
		
		Point point1 = new Point(0.0, 500.0);
		Point point2 = new Point(0.0, 2000.0);
		Point point3 = new Point(0.0, 1000.0);
		
		Planet ferengi = new Planet(point1, 500.0, new Angle(90.0), new Angle(1.0), true);
		Planet betasoide = new Planet(point2, 2000.0, new Angle(90.0), new Angle(3.0), true);
		Planet vulcano = new Planet(point3, 1000.0, new Angle(90.0), new Angle(5.0), false);
		
		SolarSystem solarSystem = new SolarSystem(ferengi, betasoide, vulcano);
		
		return solarSystem;
	}

	public static SolarSystem generatePerimeterTestSolarSystem() {
		
		Point point1 = new Point(0.0, 500.0);
		Point point2 = new Point(-500.0, 0.0);
		Point point3 = new Point(500.0, 0.0);
		
		
		
		
		Planet ferengi = new Planet(point1, 500.0, null, null, true);
		Planet betasoide = new Planet(point2, 500.0, null, null, true);
		Planet vulcano = new Planet(point3, 500.0, null, null, true);
		

		SolarSystem solarSystem = new SolarSystem(ferengi, betasoide, vulcano);
		
		return solarSystem;
	}
}
