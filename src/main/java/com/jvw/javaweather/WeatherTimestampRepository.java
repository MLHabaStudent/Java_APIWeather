package com.jvw.javaweather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherTimestampRepository extends JpaRepository<WeatherTimestamp, Long> {
    //
}
