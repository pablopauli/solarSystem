package com.mercadolibre.solarSystem.service;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.simulation.SolarSystem;

public interface ForecasterService {

	/** Executes a forecast simulation for a solar system
	  *
	  *	 @param s a SolarSystem 
	  *  @param days an int to indicate the number of days for executing the forecast simulation
	  */
	public void forecast(int days, SolarSystem s); 
	
	
	/** Gets the DayStatus of an specific day
	  *
	  *	 @param day an int 
	  *  @return DayStatus corresponding to that day
	  */
	public DayStatus getWeather(int day);
	
	
	/** Gets the result of the simulation
	  *
	  *  @return a SimulationResult of the forecast simulation
	  */
	public SimulationResult getSimulationResult();
}
