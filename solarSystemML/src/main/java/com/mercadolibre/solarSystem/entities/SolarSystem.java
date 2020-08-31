package com.mercadolibre.solarSystem.entities;

import java.util.List;

import com.mercadolibre.solarSystem.geometry.Point;
import com.mercadolibre.solarSystem.geometry.Triangle;

public class SolarSystem {
	
	private List<Planet> planets;
	
	
	
	/** A Solar System to simulate.
	  *
	  *  @constructor create a new Solar System with the planets in it
	  *  @param planets list of Planets in the Solar System
	  */
	public SolarSystem(List<Planet> planets) {
		this.planets = planets;
	}

	
	public void moveXDays(int days) {
		for (Planet planet : planets) {
			planet.moveXDays(days);
		}
	}


	public void resetSolarSystem() {
		for (Planet planet : planets) {
			planet.resetPosition();
		}
	}

	

	public List<Planet> getPlanets() {
		return planets;
	}



	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	
	public Double getPlanetsTrianglePerimeter() {
		
		Double result = 0.0;
		
		if(planets.size() == 3) {
			Point position1 = planets.get(0).getPosition();
			Point position2 = planets.get(1).getPosition();
			Point position3 = planets.get(2).getPosition();
		
			Triangle planetsTriangle = new Triangle(position1, position2, position3);
		
			result = planetsTriangle.perimeter();
		}
		
		return result;
	}

}
