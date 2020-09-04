package com.mercadolibre.solarSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.solarSystem.entities.DayStatus;

@Repository
public interface DayStatusRepository extends JpaRepository<DayStatus, Long>{

}