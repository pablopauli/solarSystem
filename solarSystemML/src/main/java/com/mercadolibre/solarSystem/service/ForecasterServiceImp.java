package com.mercadolibre.solarSystem.service;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.solarSystem.entities.SolarSystem;


@Service
public class ForecasterServiceImp implements ForecasterService{

	
	@Autowired
	private WeatherConditions weatherConditions;
	
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
		
		TreeMap<Integer, String> daysStatus = new TreeMap<Integer, String>();
		
		
		for (int i = 0; i < days; i++) {
			
			if(weatherConditions.isOptimum(s)) {
				optimumDays++;
				
				daysStatus.put(i, "Optimum day");
			}else if(weatherConditions.isDrought(s)) {
				
				droughtDays++;
				
				daysStatus.put(i, "Drought day");
			}else if(weatherConditions.isRainy(s)) {
				rainyDays++;
				
				Double planetsTrianglePerimeter = s.getPlanetsTrianglePerimeter();
				
				if(planetsTrianglePerimeter > maxTrianglePerimeter) {
					maxTrianglePerimeter = planetsTrianglePerimeter;
					maxRainyDay = i;
				}
				
				daysStatus.put(i, "Rainy day");
			}else {
				daysStatus.put(i, "Normal day");
			}
			s.moveXDays(1);
		}
		
		System.out.println("Results for " + days + "days");
		System.out.println("Optimum days: " + optimumDays);
		System.out.println("Rainy days: " + rainyDays);
		System.out.println("Drought days: " + droughtDays);
		System.out.println("maxRainy day: " + maxRainyDay + " with perimeter: " + maxTrianglePerimeter);
		
	}
	

	
	
}
