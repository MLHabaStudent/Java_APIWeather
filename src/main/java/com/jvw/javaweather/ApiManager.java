package com.jvw.javaweather;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.print.DocFlavor;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ApiManager {
    private final String apiKey = "1131bc4c169e94b562693c2ade853dbe";
    private final String geocodingAPICall = "http://api.openweathermap.org/geo/1.0/direct?";
    private final String weatherAPICall = "https://api.openweathermap.org/data/2.5/forecast?";

    public JSONArray getCityCoordinatesJSON(String cityName){
        String geocodingURL = geocodingAPICall +
                "q=" + cityName + "&limit=1&appid=" + apiKey;

        JSONArray array;
        try {
            array = readJSONArrayFromURL(geocodingURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    public JSONObject getWeatherTimestampsJSON(String lat, String lon){
        String weatherURL = weatherAPICall +
                "lat=" + lat +
                "&lon=" + lon +
                "&appid=" + apiKey;

        JSONObject object;
        try {
            object = readJSONObjectFromURL(weatherURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public JSONObject readJSONObjectFromURL(String url) throws IOException {
        try (InputStream input = new URL(url).openStream()) {
            BufferedReader re = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            String Text = Read(re);
            JSONObject json = new JSONObject(Text);
            return json;    // Returning JSON
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray readJSONArrayFromURL(String url) throws IOException {
        try (InputStream input = new URL(url).openStream()) {
            BufferedReader re = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            String response = Read(re);
            JSONArray json = new JSONArray(response);
            return json;
        } catch (Exception e) {
            return null;
        }
    }

    public String Read(Reader re) throws IOException{
        StringBuilder str = new StringBuilder();     // To Store Url Data In String.
        int temp;
        do {
            temp = re.read();
            str.append((char) temp);

        } while (temp != -1);
        return str.toString();
    }

}
