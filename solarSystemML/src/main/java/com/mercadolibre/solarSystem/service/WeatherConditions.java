package com.mercadolibre.solarSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mercadolibre.solarSystem.entities.Planet;
import com.mercadolibre.solarSystem.entities.SolarSystem;
import com.mercadolibre.solarSystem.geometry.Line;
import com.mercadolibre.solarSystem.geometry.Point;
import com.mercadolibre.solarSystem.geometry.Triangle;

@Service
public class WeatherConditions {


	
	
	 /** Checks if it a Drought day in the SolarSystem
    *
    *  @param solarSystem SolarSystem to check
    *  @return true if it is drought, false it is not
    *
    */
	public boolean isDrought(SolarSystem s) {
		
		List<Planet> planets = s.getPlanets();
		
		if(planets.size() == 3) {
		
			Point position1 = planets.get(0).getPosition();
			Point position2 = planets.get(1).getPosition();
			Point position3 = planets.get(2).getPosition();
		
			Point sunPosition = new Point(0.0,0.0);
		
			Line oneToTwoLine = new Line(position1, position2);
		
			boolean check1 = oneToTwoLine.isInLine(position3);
			
			boolean check2 = oneToTwoLine.isInLine(sunPosition);
			
			return check1 && check2;
		}
		
		return false;
	}
	
	 /** Checks if it a Rainy day in the SolarSystem
    *
    *  @param solarSystem SolarSystem to check
    *  @return true if it is a rainy day, false it is not
    *
    */
	public boolean isRainy(SolarSystem s) {
		List<Planet> planets = s.getPlanets();
		
		if(planets.size() == 3) {
		
			Point position1 = planets.get(0).getPosition();
			Point position2 = planets.get(1).getPosition();
			Point position3 = planets.get(2).getPosition();
			
			Point sunPosition = new Point(0.0,0.0);
			
			Triangle planetsTriangle = new Triangle(position1, position2, position3);
			
			return planetsTriangle.isInTriangle(sunPosition);
		}
		
		return false;
	}
	
	/** Checks if it a Optimum day in the SolarSystem
    *
    *  @param solarSystem SolarSystem to check
    *  @return true if it is an optimum day, false it is not
    *
    */
	
	public boolean isOptimum(SolarSystem s) {
	
		List<Planet> planets = s.getPlanets();
		
		if(planets.size() == 3) {
		
			Point position1 = planets.get(0).getPosition();
			Point position2 = planets.get(1).getPosition();
			Point position3 = planets.get(2).getPosition();
		
			Point sunPosition = new Point(0.0,0.0);
		
			Line oneToTwoLine = new Line(position1, position2);
		
			return oneToTwoLine.isInLine(position3) && !oneToTwoLine.isInLine(sunPosition);
		}
		
		
		
		return false;
	}
	
	
}
