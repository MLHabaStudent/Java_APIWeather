package com.jvw.javaweather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CityCoordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Float lat;
    private Float lon;

    public CityCoordinates(String name, Float lat, Float lon){
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName(){
        return name;
    }

    public Float getLat(){
        return lat;
    }

    public Float getLon(){
        return lon;
    }
}
