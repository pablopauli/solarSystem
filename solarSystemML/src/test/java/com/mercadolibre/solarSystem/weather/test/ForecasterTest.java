package com.mercadolibre.solarSystem.weather.test;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.repository.DayStatusRepository;
import com.mercadolibre.solarSystem.service.ForecasterServiceImp;
import com.mercadolibre.solarSystem.utils.SolarSystemUtils;


@RunWith(SpringRunner.class)
@DataJpaTest
@Ignore
public class ForecasterTest {

	@Autowired
	private ForecasterServiceImp forecasteService;
	
	@Autowired
	private DayStatusRepository dayStatusRepository;
	
	@Test
	public void forecastTest() {
		
		forecasteService.forecast(10, SolarSystemUtils.generateTestSolarSystem());
		
		DayStatus dayStatus = dayStatusRepository.findById((long) 0).get();
		
		assertTrue(dayStatus.getWeather().equals("sequia"));
	}
}
