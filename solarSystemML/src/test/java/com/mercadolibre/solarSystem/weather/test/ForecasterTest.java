package com.mercadolibre.solarSystem.weather.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolibre.solarSystem.entities.Planet;
import com.mercadolibre.solarSystem.entities.SolarSystem;
import com.mercadolibre.solarSystem.geometry.Angle;
import com.mercadolibre.solarSystem.geometry.Point;
import com.mercadolibre.solarSystem.service.ForecasterServiceImp;

public class ForecasterTest {

	@Autowired
	private ForecasterServiceImp forecasteService;
	
	@Test
	public void forecastTest() {
		
	
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
		SolarSystem s = new SolarSystem(planets );
		
		forecasteService.forecast(10*365, s);
	}
}
