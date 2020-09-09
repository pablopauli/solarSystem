package com.mercadolibre.solarSystem.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.service.ForecasterServiceImp;
import com.mercadolibre.solarSystem.utils.SolarSystemUtils;

@RestController
public class SolarSystemController {

	
	@Autowired
	private ForecasterServiceImp forecasterService;
	
	
	
	@PostMapping("/simular")
	public ResponseEntity<Void> simulateForecast() {

		forecasterService.forecast(10*365, SolarSystemUtils.generateMainSolarSystem());
		
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/resultado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimulationResult> getForecastResult() {
		
		SimulationResult simulationResult = forecasterService.getSimulationResult();
		
		return ResponseEntity.ok().body(simulationResult);
	}
	
	
	@GetMapping(value = "/clima", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DayStatus> getWeather(@Validated @RequestParam(value = "dia") long day) {

		DayStatus dayStatus = forecasterService.getWeather(day);
		
		
		return ResponseEntity.ok().body(dayStatus);
		
		
	}

	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Void> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
	    
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Void> noSuchElement(NoSuchElementException ex) {
	    
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<Void> indexOutOfBounds(IndexOutOfBoundsException ex) {
	    
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
