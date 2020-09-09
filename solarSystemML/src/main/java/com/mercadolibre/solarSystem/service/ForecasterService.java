package com.mercadolibre.solarSystem.service;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.simulation.SolarSystem;

public interface ForecasterService {

	/** Executes forecast for a solar system
	  *
	  *	 @param s a SolarSystem 
	  *  @param days an int to indicate the number of days for executing the forecast
	  */
	public void forecast(int days, SolarSystem s); 
	
	
	/** Gets the DayStatus of an specific day
	  *
	  *	 @param day a long 
	  *  @return DayStatus corresponding to that day
	  */
	public DayStatus getWeather(long day);
	
	
	/** Gets the result of the simulation
	  *
	  *  @return a SimulationResult
	  */
	public SimulationResult getSimulationResult();
}
