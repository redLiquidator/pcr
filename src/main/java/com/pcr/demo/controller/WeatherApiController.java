package com.pcr.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//consume API using restTemplate
//A rest web service availavle in this endpoint that provides a list of weathers
//https://openweathermap.org/current
//weather of seoul
//https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=b1b08db5119d69275c4239db34a973dc
//weather of cities within a rectangle zone
//https://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b1b08db5119d69275c4239db34a973dc
//create restTemplate bean ->autowire it into the restController -> call the webservice using the getForObject method
//How to Consume rest apis in spring boot - 2 methods | kindson the tech pro
@RestController
public class WeatherApiController {

	
	private static String weather_url = "https://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b1b08db5119d69275c4239db34a973dc";
	private static String todayWeather_url = "https://api.openweathermap.org/data/2.5/weather?q=Abbotsford&appid=b1b08db5119d69275c4239db34a973dc";
	
	@GetMapping("/weathers")
	public Object getWeathers(){
		RestTemplate restTemplate = new RestTemplate(); 
		//Object[] weathers =restTemplate.getForObject(url,Object[].class);
		Object weathers =restTemplate.getForObject(weather_url,Object.class);
		//return Arrays.asList(weathers);
		return weathers;
	}
	
	@GetMapping("/todayWeather")
	public Object getTodayWeather(){
	    RestTemplate restTemplate = new RestTemplate();  //without this, RestTemplate null error occurs
		Object todayWeather =restTemplate.getForObject(todayWeather_url,Object.class);
		//let's take this object todayWeather goes to FrontPageController.front()-> index.html
		return todayWeather;
	}
}
