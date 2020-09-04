package com.mercadolibre.solarSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "day_status")
public class DayStatus {

	@Id
    @Column(name = "day")
    public Long day;


    @Column(name = "weather")
    public String weather;
    
    public DayStatus() {}
    
    public DayStatus(long day, String weather) {
    	this.day = day;
    	this.weather = weather;
    }

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

    
    

}