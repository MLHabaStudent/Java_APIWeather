package com.jvw.javaweather;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class WeatherTimestampController {
    private final WeatherTimestampRepository repository;

    WeatherTimestampController(WeatherTimestampRepository repository){
        this.repository = repository;
    }

    @GetMapping("/weather")
    List<WeatherTimestamp> all() {
        return repository.findAll();
    }

    @PostMapping("/weather")
    WeatherTimestamp newWeatherTimestamp(@RequestBody WeatherTimestamp newWeatherTimestamp) {
        return repository.save(newWeatherTimestamp);
    }

    @GetMapping("/")
    public String main(){
        return "main page";
    }
}
