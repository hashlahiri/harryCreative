//author @Chanakya Lahiri
package com.weatherapp.myWeatherApp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrentWeather implements Serializable{

	private String description;
	private BigDecimal temperature;
	private BigDecimal feelsLike;
	private BigDecimal humidity;
	private BigDecimal windSpeed;
	private String country;
	private String cityname;
	
	public CurrentWeather(String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal humidity,
			BigDecimal windSpeed, String country, String cityname) {
		this.description = description;
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
		this.country = country;
		this.cityname = cityname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(BigDecimal feelsLike) {
		this.feelsLike = feelsLike;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public String toString() {
		return "CurrentWeather [description=" + description + ", temperature=" + temperature + ", feelsLike="
				+ feelsLike + ", humidity=" + humidity + ", windSpeed=" + windSpeed + ", country=" + country
				+ ", cityname=" + cityname + "]";
	}
	
}
