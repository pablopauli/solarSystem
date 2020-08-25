package solarSystemML.entities;

import java.util.List;

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

}
