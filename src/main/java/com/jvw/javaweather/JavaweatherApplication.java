package com.jvw.javaweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.util.Scanner;

@SpringBootApplication
public class JavaweatherApplication {

	public static void main(String[] args) {
		String cityName;
		Boolean running = Boolean.TRUE;

		SpringApplication.run(JavaweatherApplication.class, args);
		ApiManager apiManager = new ApiManager();
		JsonParser jsonParser = new JsonParser();
		CityCoordinates city = null;
		WeatherTimestamp[] weatherTimestamps = null;

		Scanner sc = new Scanner(System.in);

		while (running == Boolean.TRUE)
		{
			System.out.println("Podaj miasto:");
			cityName = sc.nextLine();

			if(cityName == "q")
				running = Boolean.FALSE;

			city = jsonParser.getCityCoordinates(apiManager.getCityCoordinatesJSON(cityName));

			if(city != null)
			{
				System.out.print( "City coordinates: " + city.getName().toString() +
						"\nLat: " + city.getLat().toString() +
						"\nLon: " + city.getLon().toString() + "\n");

				weatherTimestamps = jsonParser.
						getWeatherTimestamps(apiManager.
								getWeatherTimestampsJSON(city.getLat().toString(),
										city.getLon().toString()));

				if (weatherTimestamps != null)
				{

					Double tempC = weatherTimestamps[0].getTemp()-273.0;
					System.out.print( "Weather: " + weatherTimestamps[0].getDescription() +
							"\nTemp: " + new DecimalFormat("#0.00").format(tempC) +
							"\nWind: " + weatherTimestamps[0].getWind().toString());
				} else {
					System.out.print("Niepoprawny odczyt pogody!");
				}

			} else {
				System.out.print("Niepoprawny odczyt miasta!");
			}

			System.out.print("\n");
		}
	}

}
