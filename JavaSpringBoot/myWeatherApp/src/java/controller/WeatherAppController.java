//author @Chanakya Lahiri
package com.weatherapp.myWeatherApp.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapp.myWeatherApp.model.CurrentWeather;
import com.weatherapp.myWeatherApp.service.LiveWeatherService;

@Controller
public class WeatherAppController {

	@Autowired
	private LiveWeatherService liveWeatherService;

	public void CurrentWeatherController(LiveWeatherService liveWeatherService) {
		this.liveWeatherService = liveWeatherService;
	}

	@GetMapping("/")
	public String enterCity(Model model) {
		
		System.out.println("Index Page Opened");
		
		return "mainPage";
	}
	
	@GetMapping("/search")
	public String getCurrentWeather(@RequestParam("theCityName") String theCity, Model model) {
		
		model.addAttribute("currentWeather", liveWeatherService.getCurrentWeather(theCity));
			
		return "home";
	}
}