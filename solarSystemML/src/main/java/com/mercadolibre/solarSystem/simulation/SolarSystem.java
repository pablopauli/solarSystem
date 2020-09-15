package com.mercadolibre.solarSystem.simulation;

public class SolarSystem {
	
	
	private Planet ferengi;
	private Planet betasoide;
	private Planet vulcano;

	
	
	/** A Solar System.
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

	
	/** 
	  *	Moves the planets in its orbit a quantity of days
	  *
	  *	@param days an int to specify the number of days to move the planets
	  *  
	  */
	public void moveXDays(int days) {
		ferengi.moveXDays(days);
		betasoide.moveXDays(days);
		vulcano.moveXDays(days);
	}


	
	/** 
	  *	Gets the perimeter of the Triangle form by the planets
	  *  
	  *  @return a Double with the value of the perimeter
	  */
	public Double getPlanetsTrianglePerimeter() {
		
		Double result = 0.0;
		
		Point position1 = ferengi.getPosition();
		Point position2 = betasoide.getPosition();
		Point position3 = vulcano.getPosition();
		
		Triangle planetsTriangle = new Triangle(position1, position2, position3);
		
		result = planetsTriangle.perimeter();
		
		// rounded to 3 decimals units
		double roundOffResult = Math.round(result * 1000.0) / 1000.0;
		
		return roundOffResult;
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
