package com.mercadolibre.solarSystem.weather.test;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.repository.DayStatusRepository;
import com.mercadolibre.solarSystem.repository.SimulationResultRepository;
import com.mercadolibre.solarSystem.service.ForecasterService;
import com.mercadolibre.solarSystem.service.ForecasterServiceImp;
import com.mercadolibre.solarSystem.utils.SolarSystemUtils;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ForecasterTest {

	@Autowired
	private ForecasterServiceImp forecasteService;
	
	@Autowired
	private DayStatusRepository dayStatusRepository;
	
	@Autowired
	private SimulationResultRepository simulationResultRepository;
	
	
	@TestConfiguration
    static class ForecasterServiceImpTestContextConfiguration {
 
        @Bean
        public ForecasterService forecasterService() {
            return new ForecasterServiceImp();
        }
    }
	
	
	@BeforeEach
	public void deleteData() {
		dayStatusRepository.deleteAll();
		simulationResultRepository.deleteAll();
	}
	
	@Test
	public void forecastOneDayTest() {
		
		forecasteService.forecast(1, SolarSystemUtils.generateMainSolarSystem());
		
		DayStatus dayStatus = forecasteService.getWeather(0);
		assertTrue(dayStatus.getWeather().equals("sequia"));
		
		SimulationResult simulationResult = forecasteService.getSimulationResult();
		
		assertTrue(simulationResult.getDays()==1);
		assertTrue(simulationResult.getDroughtDays()==1);
		assertTrue(simulationResult.getMaxRainyDay()==0);
		assertTrue(simulationResult.getOptimumDays()==0);
		assertTrue(simulationResult.getRainyDays()==0);
		//no rainy day, so perimeter equals to initial value
		assertTrue(simulationResult.getMaxTrianglePerimeter()==-1.0);
	}
	
	@Test
	public void forescastAHundredDaysTest() {
		forecasteService.forecast(100, SolarSystemUtils.generateMainSolarSystem());
		SimulationResult simulationResult = forecasteService.getSimulationResult();

		
		assertTrue(simulationResult.getDays()==100);
		assertTrue(simulationResult.getDroughtDays()==2);
		assertTrue(simulationResult.getMaxRainyDay()==72);
		assertTrue(simulationResult.getOptimumDays()==0);
		assertTrue(simulationResult.getRainyDays()==38);
		assertTrue(simulationResult.getMaxTrianglePerimeter()==6262.295);

	}
	
	@Test
	public void getWeatherWithNoSimulationTest() {
		try {
			DayStatus dayStatus = forecasteService.getWeather(0);
		    Assert.fail(); 
		} catch (Exception ex) {  
			assertTrue(ex.getClass().equals(NoSuchElementException.class));
		}
	
	}
	
	
	@Test
	public void getWeatherOutOfRangeDayTest() {
		
		forecasteService.forecast(1, SolarSystemUtils.generateMainSolarSystem());
		
		try {
			DayStatus dayStatus = forecasteService.getWeather(4);
			Assert.fail(); 
		} catch (Exception ex) {  
			assertTrue(ex.getClass().equals(NoSuchElementException.class));
		}
	
	}
	
	@Test
	public void getSimulationResultWithNoSimulationTest() {
		try {
			SimulationResult simulationResult = forecasteService.getSimulationResult();
		    Assert.fail(); 
		} catch (Exception ex) {  
			assertTrue(ex.getClass().equals(IndexOutOfBoundsException.class));
		}
	
	}
}
