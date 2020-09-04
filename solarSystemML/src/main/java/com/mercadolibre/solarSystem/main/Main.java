package com.mercadolibre.solarSystem.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableCaching
@SpringBootApplication
@EnableJpaRepositories({"com.mercadolibre.solarSystem.repository"})
@ComponentScan({"com.mercadolibre"})   
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan({"com.mercadolibre.solarSystem.entities"})
public class Main {


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
