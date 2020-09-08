package com.mercadolibre.solarSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "simulation_result")
public class SimulationResult {

	
	@Id
    @Column(name = "days")
    public int days;


    @Column(name = "optimum_days")
    public int optimumDays;
    
    @Column(name = "rainy_days")
    public int rainyDays;
    
    @Column(name = "drought_days")
    public int droughtDays;
    
    @Column(name = "max_rainy_days")
    public int maxRainyDay;
    
    @Column(name = "max_triangle_perimeter")
    public Double maxTrianglePerimeter;
    
    
    public SimulationResult() {}


	public SimulationResult(int days, int optimumDays, int rainyDays, int droughtDays, int maxRainyDay,
			Double maxTrianglePerimeter) {
		super();
		this.days = days;
		this.optimumDays = optimumDays;
		this.rainyDays = rainyDays;
		this.droughtDays = droughtDays;
		this.maxRainyDay = maxRainyDay;
		this.maxTrianglePerimeter = maxTrianglePerimeter;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public int getOptimumDays() {
		return optimumDays;
	}


	public void setOptimumDays(int optimumDays) {
		this.optimumDays = optimumDays;
	}


	public int getRainyDays() {
		return rainyDays;
	}


	public void setRainyDays(int rainyDays) {
		this.rainyDays = rainyDays;
	}


	public int getDroughtDays() {
		return droughtDays;
	}


	public void setDroughtDays(int droughtDays) {
		this.droughtDays = droughtDays;
	}


	public int getMaxRainyDay() {
		return maxRainyDay;
	}


	public void setMaxRainyDay(int maxRainyDay) {
		this.maxRainyDay = maxRainyDay;
	}


	public Double getMaxTrianglePerimeter() {
		return maxTrianglePerimeter;
	}


	public void setMaxTrianglePerimeter(Double maxTrianglePerimeter) {
		this.maxTrianglePerimeter = maxTrianglePerimeter;
	}
    
	
	
 
}
