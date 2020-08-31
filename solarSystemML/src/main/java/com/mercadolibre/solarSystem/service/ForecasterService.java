package com.mercadolibre.solarSystem.service;

import com.mercadolibre.solarSystem.entities.SolarSystem;

public interface ForecasterService {

	/** Executes forecast for a solar system
	  *
	  *	 @param s a SolarSystem 
	  *  @param days an int to indicate the number of days for executing the forecast
	  */
	public void forecast(int days, SolarSystem s); 
}
