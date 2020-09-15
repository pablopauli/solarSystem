package com.mercadolibre.solarSystem.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.repository.DayStatusRepository;
import com.mercadolibre.solarSystem.repository.SimulationResultRepository;
import com.mercadolibre.solarSystem.simulation.SolarSystem;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ForecasterServiceImp implements ForecasterService{

	
	
	private WeatherConditions weatherConditions = new WeatherConditions();
	
	@Autowired
	private DayStatusRepository dayStatusRepository;
	
	@Autowired
	private SimulationResultRepository simulationResultRepository;
	
	
	/** Executes a forecast simulation for a solar system
	  *
	  *	 @param s a SolarSystem 
	  *  @param days an int to indicate the number of days for executing the forecast simulation
	  */
	public void forecast(int days, SolarSystem s) {
		
		log.info("Executing ForecasterServiceImp forecast method");
		
		//counters
		int rainyDays = 0;
		int droughtDays = 0;
		int optimumDays = 0;
		
		
		int maxRainyDay = 0;
		Double maxTrianglePerimeter = -1.0;
		
		
		ArrayList<DayStatus> dayStatusList = new ArrayList<DayStatus>();
		
		DayStatus dayStatus;
		
		
		for (int i = 0; i < days; i++) {
			
			if(weatherConditions.isOptimum(s)) {
				optimumDays++;
				
				dayStatus = new DayStatus(i, "optimo");
			}else if(weatherConditions.isDrought(s)) {
				
				droughtDays++;
				
				dayStatus = new DayStatus(i, "sequia");
			}else if(weatherConditions.isRainy(s)) {
				rainyDays++;
				
				Double planetsTrianglePerimeter = s.getPlanetsTrianglePerimeter();
				
				if(planetsTrianglePerimeter > maxTrianglePerimeter) {
					maxTrianglePerimeter = planetsTrianglePerimeter;
					maxRainyDay = i;
				}
				
				dayStatus = new DayStatus(i, "lluvia");
			}else {
				dayStatus = new DayStatus(i, "normal");
			}
			
			log.info("Adding dayStatus {} to list", dayStatus);
			
			dayStatusList.add(dayStatus);
			s.moveXDays(1);
		}
		
		log.info("Saving all DayStatus data");
		dayStatusRepository.saveAll(dayStatusList);
		

		log.info("Results for " + days + "days");
		log.info("Optimum days: " + optimumDays);
		log.info("Rainy days: " + rainyDays);
		log.info("Drought days: " + droughtDays);
		log.info("maxRainy day: " + maxRainyDay + " with perimeter: " + maxTrianglePerimeter);
		
		SimulationResult simResult = new SimulationResult(days, optimumDays, rainyDays, droughtDays, maxRainyDay, maxTrianglePerimeter);
		
		log.info("Saving SimulationResult data");
		simulationResultRepository.save(simResult);
		
	}
	
	/** Gets the DayStatus of an specific day
	  *
	  *	 @param day an int 
	  *  @return DayStatus corresponding to that day
	  */
	public DayStatus getWeather(int day) {
		log.info("Executing getWeather method");
		return dayStatusRepository.findById(day).get();
	}

	/** Gets the result of the simulation
	  *
	  *  @return a SimulationResult of the forecast simulation
	  */
	public SimulationResult getSimulationResult() {
		log.info("Executing getSimulationResult method");
		return simulationResultRepository.findAll().get(0);
	}
	

	
	
}
