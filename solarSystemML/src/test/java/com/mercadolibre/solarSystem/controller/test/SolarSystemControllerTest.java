package com.mercadolibre.solarSystem.controller.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MimeTypeUtils;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.mercadolibre.solarSystem.controller.SolarSystemController;
import com.mercadolibre.solarSystem.entities.DayStatus;
import com.mercadolibre.solarSystem.entities.SimulationResult;
import com.mercadolibre.solarSystem.service.ForecasterServiceImp;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SolarSystemController.class)
//@AutoConfigureJsonTesters
//@AutoConfigureMockMvc
//@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SolarSystemControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ForecasterServiceImp forecastServiceImp;
	
//	@Autowired
//	private SimulationResultRepository simulationResultRepository;
	
	
	
	@Test
	public void getForecastResultTest() throws Exception {
		
		doReturn(new SimulationResult(10, 2, 2, 3, 5, 2.23)).when(forecastServiceImp).getSimulationResult();
		
		mockMvc.perform(get("/resultado")
				.accept(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.days").value(10))
			.andExpect(MockMvcResultMatchers.jsonPath("$.rainyDays").value(2))
			.andExpect(MockMvcResultMatchers.jsonPath("$.droughtDays").value(3))
			.andExpect(MockMvcResultMatchers.jsonPath("$.optimumDays").value(2))
			.andExpect(MockMvcResultMatchers.jsonPath("$.maxRainyDay").value(5))
			.andExpect(MockMvcResultMatchers.jsonPath("$.maxTrianglePerimeter").value(2.23));
	}
	
	
	
	@Test
	public void getWeatherTest() throws Exception {
		
		doReturn(new DayStatus(1, "sequia")).when(forecastServiceImp).getWeather(1);
	
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/clima?dia={dia}", 1)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(MockMvcResultHandlers.print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.day").value(1))
			      .andExpect(MockMvcResultMatchers.jsonPath("$.weather").value("sequia"));
	}
	
	@Test
	public void getWeatherNotFoundTest() throws Exception {
	
		when(forecastServiceImp.getWeather(anyInt())).thenThrow(NoSuchElementException.class);
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/clima?dia={dia}", 1)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(MockMvcResultHandlers.print())
			      .andExpect(status().isNotFound());
			      
		
	}
	
	
	@Test
	public void getSimulationResultNotFoundTest() throws Exception {
	
		when(forecastServiceImp.getSimulationResult()).thenThrow(IndexOutOfBoundsException.class);
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/resultado")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(MockMvcResultHandlers.print())
			      .andExpect(status().isNotFound());
			      
		
	}
}
