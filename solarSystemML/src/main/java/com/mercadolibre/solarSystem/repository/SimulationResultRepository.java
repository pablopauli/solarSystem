package com.mercadolibre.solarSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.solarSystem.entities.SimulationResult;


/**
 * The SimulationResult Repository, managing all operations over the SimulationResult entity
 */
@Repository
public interface SimulationResultRepository extends JpaRepository<SimulationResult, Integer>{

}
