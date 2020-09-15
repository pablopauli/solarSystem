package com.mercadolibre.solarSystem.service;

import org.springframework.stereotype.Service;

import com.mercadolibre.solarSystem.simulation.Line;
import com.mercadolibre.solarSystem.simulation.Point;
import com.mercadolibre.solarSystem.simulation.SolarSystem;
import com.mercadolibre.solarSystem.simulation.Triangle;

@Service
public class WeatherConditions {
	
	
	 /** Checks if it a Drought day in the SolarSystem
    *
    *  @param solarSystem SolarSystem to check
    *  @return true if it is drought, false it is not
    *
    */
	public boolean isDrought(SolarSystem solarSystem) {
		
		Point position1 = solarSystem.getFerengi().getPosition();
		Point position2 = solarSystem.getBetasoide().getPosition();
		Point position3 = solarSystem.getVulcano().getPosition();
		
		Point sunPosition = new Point(0.0,0.0);
		
		Line oneToTwoLine = new Line(position1, position2);
		
			
		return oneToTwoLine.isInLine(position3) && oneToTwoLine.isInLine(sunPosition);
		
	}
	
	 /** Checks if it a Rainy day in the SolarSystem
    *
    *  @param solarSystem SolarSystem to check
    *  @return true if it is a rainy day, false it is not
    *
    */
	public boolean isRainy(SolarSystem solarSystem) {

		
			Point position1 = solarSystem.getFerengi().getPosition();
			Point position2 = solarSystem.getBetasoide().getPosition();
			Point position3 = solarSystem.getVulcano().getPosition();
			
			Point sunPosition = new Point(0.0,0.0);
			
			Triangle planetsTriangle = new Triangle(position1, position2, position3);
			
			return planetsTriangle.isInTriangle(sunPosition);

	}
	
	/** Checks if it a Optimum day in the SolarSystem
    *
    *  @param solarSystem SolarSystem to check
    *  @return true if it is an optimum day, false it is not
    *
    */
	
	public boolean isOptimum(SolarSystem solarSystem) {
	

			Point position1 = solarSystem.getFerengi().getPosition();
			Point position2 = solarSystem.getBetasoide().getPosition();
			Point position3 = solarSystem.getVulcano().getPosition();
		
			Point sunPosition = new Point(0.0,0.0);
		
			Line oneToTwoLine = new Line(position1, position2);
		
			return oneToTwoLine.isInLine(position3) && !oneToTwoLine.isInLine(sunPosition);
	}
	
	
}
