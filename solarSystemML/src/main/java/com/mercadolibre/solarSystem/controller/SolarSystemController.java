package com.mercadolibre.solarSystem.controller;

import java.util.NoSuchElementException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SolarSystemController {

	
	@Autowired
	private ForecasterServiceImp forecasterService;
	
	
	
	/**
	 * Simulates a Solar System for 10 years and saves it in the database
	 * 
	 * @return
	 * [200-OK] -- if the simulation was successful.<br>
	 * 
	 */
	@ApiOperation(value = "Simulates a Solar System for 10 years and saves it in the database", response = SimulationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "if the simulation was successful."),
    	}
    )
	@PostMapping("/simular")
	public ResponseEntity<Void> simulateForecast() {

		log.info("Calling ForecastService forecast method");
		forecasterService.forecast(10*365, SolarSystemUtils.generateMainSolarSystem());
		
		
		return ResponseEntity.ok().build();
	}
	
	
	/**
	 * Gets the result of the Solar System simulation
	 * @return
	 * [200-OK] -- with the SimulationResult data in the response body.<br>
	 * [404-NOT_FOUND] -- if no simulation was ran and no SimulationResult was found.<br>
	 */
	@ApiOperation(value = "Gets the Simulation result", response = SimulationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "if a SimulationResult was found"),
            @ApiResponse(code = 404, message = "if no simulation was ran and no SimulationResult was found")
    	}
    )
	@GetMapping(value = "/resultado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimulationResult> getForecastResult() {
		
		log.info("Calling ForecastService getSimulationResult method");
		
		SimulationResult simulationResult = forecasterService.getSimulationResult();
		
		log.info("Result for getSimulationResult = {}", simulationResult);
		
		return ResponseEntity.ok().body(simulationResult);
	}
	
	
	/**
	 * Checks the weather of an specific day
	 * @param day
	 * The day to check its weather
	 * @return
	 * [200-OK] -- with the DayStatus data in the response body.<br>
	 * [404-NOT_FOUND] -- if the simulation was not ran or the day entered is not in the simulated range.<br>
	 * [400-BAD_REQUEST] -- if the day used as input is not an int.<br>
	 */
	@ApiOperation(value = "Gets the Simulation result", response = DayStatus.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "if a DayStatus was found"),
            @ApiResponse(code = 400, message = "if the day used as input is not an int"),
            @ApiResponse(code = 404, message = "if the simulation was not ran or the day entered is not in the simulated range")
    	}
    )
	@GetMapping(value = "/clima", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DayStatus> getWeather(@Validated @RequestParam(value = "dia") int day) {

		log.info("Calling ForecastService getWeather method");
		
		DayStatus dayStatus = forecasterService.getWeather(day);
		
		
		log.info("Result for getWeather with [{}] = {}", day, dayStatus);
		
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
