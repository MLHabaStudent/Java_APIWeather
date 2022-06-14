package com.jvw.javaweather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherTimestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long dt;
    private Float temp;
    private Float pressure;
    private Float humidity;
    private String description;
    private Float clouds;
    private Float wind;
    private String dateText;

    public WeatherTimestamp(Long dt, Float temp, Float pressure, Float humidity,
        String description, Float clouds, Float wind, String dateText){
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.description = description;
        this.clouds = clouds;
        this.wind = wind;
        this.dateText = dateText;
    }

    public Long getId(){
        return id;
    }

    public Long getDt() {return dt;}

    public Float getTemp(){
        return temp;
    }

    public Float getPressure(){
        return pressure;
    }

    public Float getHumidity(){
        return humidity;
    }

    public String getDescription(){
        return description;
    }

    public Float getClouds(){
        return clouds;
    }

    public Float getWind(){
        return wind;
    }

    public String getDateText(){
        return dateText;
    }

}
