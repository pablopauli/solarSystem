package com.mercadolibre.solarSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.solarSystem.entities.DayStatus;


/**
 * The DayStatus Repository, managing all operations over the DayStatus entity
 */
@Repository
public interface DayStatusRepository extends JpaRepository<DayStatus, Integer>{

}