package com.jvw.javaweather;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

    public WeatherTimestamp[] getWeatherTimestamps(JSONObject object){
        if(object == null)
            return null;
        final int timestamps = object.getInt("cnt");
        WeatherTimestamp[] weatherTimestamps = new WeatherTimestamp[timestamps];
        JSONArray timestampsArray = object.getJSONArray("list");

        for (int it = 0; it < timestamps; it++){
            weatherTimestamps[it] = getWeatherTimestamp(timestampsArray.getJSONObject(it));
        }
        return weatherTimestamps;
    }

    private WeatherTimestamp getWeatherTimestamp(JSONObject object){
        if(object == null)
            return null;
        Long dt = object.getLong("dt");
        Float temp = object.getJSONObject("main").getFloat("temp"),
                pressure = object.getJSONObject("main").getFloat("pressure"),
                humidity = object.getJSONObject("main").getFloat("humidity"),
                clouds = object.getJSONObject("clouds").getFloat("all"),
                wind = object.getJSONObject("wind").getFloat("speed");
        String description = object.getJSONArray("weather").getJSONObject(0).getString("description"),
                dateText = object.getString("dt_txt");

        WeatherTimestamp weatherTimestamp = new WeatherTimestamp(dt, temp, pressure, humidity, description,
                clouds, wind, dateText);
        return weatherTimestamp;
    }

    public CityCoordinates getCityCoordinates(JSONArray array){
        if(array == null)
            return null;
        if(array.isEmpty())
            return null;
        JSONObject object = array.getJSONObject(0);
        String name = object.getString("name");
        Float lat = object.getFloat("lat"),
                lon = object.getFloat("lon");

        CityCoordinates cityCoordinates = new CityCoordinates(name, lat, lon);
        return cityCoordinates;
    }
}
