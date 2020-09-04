package com.mercadolibre.solarSystem.service;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SolarSystem;
import com.mercadolibre.solarSystem.repository.DayStatusRepository;


@Service
public class ForecasterServiceImp implements ForecasterService{

	
	@Autowired
	private WeatherConditions weatherConditions;
	
	@Autowired
	private DayStatusRepository dayStatusRepository;
	
	
	/** Executes forecast for a solar system
	  *
	  *	 @param s a SolarSystem 
	  *  @param days an int to indicate the number of days for executing the forecast
	  */
	public void forecast(int days, SolarSystem s) {
		
		//counters
		int rainyDays = 0;
		int droughtDays = 0;
		int optimumDays = 0;
		
		
		int maxRainyDay = 0;
		Double maxTrianglePerimeter = -1.0;
		
		//delete any old data before simulation
		dayStatusRepository.deleteAll();
		
		DayStatus dayStatus;
		
		
		for (int i = 0; i < days; i++) {
			
			if(weatherConditions.isOptimum(s)) {
				optimumDays++;
				
				dayStatus = new DayStatus(i, "Optimum day");
			}else if(weatherConditions.isDrought(s)) {
				
				droughtDays++;
				
				dayStatus = new DayStatus(i, "Drought day");
			}else if(weatherConditions.isRainy(s)) {
				rainyDays++;
				
				Double planetsTrianglePerimeter = s.getPlanetsTrianglePerimeter();
				
				if(planetsTrianglePerimeter > maxTrianglePerimeter) {
					maxTrianglePerimeter = planetsTrianglePerimeter;
					maxRainyDay = i;
				}
				
				dayStatus = new DayStatus(i, "Rainy day");
			}else {
				dayStatus = new DayStatus(i, "Normal day");
			}
			
			dayStatusRepository.save(dayStatus);
			s.moveXDays(1);
		}
		
		System.out.println("Results for " + days + "days");
		System.out.println("Optimum days: " + optimumDays);
		System.out.println("Rainy days: " + rainyDays);
		System.out.println("Drought days: " + droughtDays);
		System.out.println("maxRainy day: " + maxRainyDay + " with perimeter: " + maxTrianglePerimeter);
		
	}
	
	
	public DayStatus getWeather(long day) {
		return dayStatusRepository.findById(day).get();
	}
	

	
	
}
