//author @Chanakya Lahiri
package com.weatherapp.myWeatherApp.service;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.myWeatherApp.model.CurrentWeather;

@Service
public class LiveWeatherService {

	//private static String W_URL="http://api.openweathermap.org/data/2.5/weather?q=London&appid=USED OPENWEATHER API";
	
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LiveWeatherService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public CurrentWeather getCurrentWeather(String city) {
    	
    	String W_URL = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=USED OPENWEATHER API";
    	
        ResponseEntity<String> response = restTemplate.getForEntity(W_URL, String.class);
        System.out.println(response);
        
        return convert(response);
    }

    //convert from json to data
    private CurrentWeather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new CurrentWeather(
            		root.path("weather").get(0).path("description").asText(),
                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("humidity").asDouble()),
                    BigDecimal.valueOf(root.path("wind").path("speed").asDouble()),
                    root.path("sys").path("country").asText(),
                    root.path("name").asText()
                    );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
