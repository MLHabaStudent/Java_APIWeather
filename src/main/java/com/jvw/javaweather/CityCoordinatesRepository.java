package com.jvw.javaweather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityCoordinatesRepository extends JpaRepository<CityCoordinates, Long> {
    //
}
