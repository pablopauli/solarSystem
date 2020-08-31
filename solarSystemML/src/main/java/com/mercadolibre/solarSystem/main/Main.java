package com.mercadolibre.solarSystem.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.mercadolibre.solarSystem.controller.SolarSystemController;


@EnableCaching
@SpringBootApplication
@ComponentScan({"com.mercadolibre"})
public class Main {


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
