package com.mercadolibre.solarSystem.simulation;

import java.util.List;

public class SolarSystem {
	
	
	private Planet ferengi;
	private Planet betasoide;
	private Planet vulcano;

	
	
	/** A Solar System to simulate.
	  *
	  *  @param ferengi a Planet
	  *  @param betasoide a Planet
	  *  @param vulcano a Planet
	  */
	public SolarSystem(Planet ferengi, Planet betasoide, Planet vulcano) {
		this.ferengi = ferengi;
		this.betasoide = betasoide;
		this.vulcano = vulcano;
	}

	
	public void moveXDays(int days) {
		ferengi.moveXDays(days);
		betasoide.moveXDays(days);
		vulcano.moveXDays(days);
	}


	public void resetSolarSystem() {
		ferengi.resetPosition();
		betasoide.resetPosition();
		vulcano.resetPosition();
	}
	
	
	public Double getPlanetsTrianglePerimeter() {
		
		Double result = 0.0;
		
		Point position1 = ferengi.getPosition();
		Point position2 = betasoide.getPosition();
		Point position3 = vulcano.getPosition();
		
		Triangle planetsTriangle = new Triangle(position1, position2, position3);
		
		result = planetsTriangle.perimeter();
		
		return result;
	}


	public Planet getFerengi() {
		return ferengi;
	}


	public void setFerengi(Planet ferengi) {
		this.ferengi = ferengi;
	}


	public Planet getBetasoide() {
		return betasoide;
	}


	public void setBetasoide(Planet betasoide) {
		this.betasoide = betasoide;
	}


	public Planet getVulcano() {
		return vulcano;
	}


	public void setVulcano(Planet vulcano) {
		this.vulcano = vulcano;
	}
	
	

}
