package com.mercadolibre.solarSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.Planet;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.entities.SolarSystem;
import com.mercadolibre.solarSystem.geometry.Angle;
import com.mercadolibre.solarSystem.geometry.Point;
import com.mercadolibre.solarSystem.repository.DayStatusRepository;
import com.mercadolibre.solarSystem.service.ForecasterServiceImp;

@RestController
public class SolarSystemController {

	
	@Autowired
	private ForecasterServiceImp forecasterService;
	
	
	
	@GetMapping("/simular")
	public String simulateForecast() {

		Point p1 = new Point(0.0, 500.0);
		Point p2 = new Point(0.0, 2000.0);
		Point p3 = new Point(0.0, 1000.0);
		
		Planet ferengi = new Planet(p1, 500.0, new Angle(90.0), new Angle(1.0), true);
		Planet betasoide = new Planet(p2, 2000.0, new Angle(90.0), new Angle(3.0), true);
		Planet vulcano = new Planet(p3, 1000.0, new Angle(90.0), new Angle(5.0), false);
		
		List<Planet> planets = new ArrayList<Planet>();
		planets.add(ferengi);
		planets.add(betasoide);
		planets.add(vulcano);
		SolarSystem s = new SolarSystem(planets);
		forecasterService.forecast(10*365, s);
		
		
		//que devolver aca?
		return "Simulacion terminada";
	}
	
	@GetMapping(value = "/resultado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimulationResult> forecastResult() {
		
		SimulationResult simResult = forecasterService.getSimulationResult();
		
		return ResponseEntity.ok().body(simResult);
	}
	
	
	@GetMapping(value = "/clima", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DayStatus> getWeather(@RequestParam(value = "dia") long day) {

				DayStatus dayStatus = forecasterService.getWeather(day);

		        return ResponseEntity.ok().body(dayStatus);
		
		
	}

}
