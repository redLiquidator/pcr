package com.pcr.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrontPageController {

	    //fetch the front page
		@GetMapping("/front")     
		public ModelAndView front() {	
		System.out.println("FrontPageController>front");
	    //assign index.html file to mv
	    ModelAndView mv = new ModelAndView("front.html");
	    
	    WeatherApiController weatherApiController = new WeatherApiController();
	    System.out.println(weatherApiController.getTodayWeather());
	     mv.addObject("todayWeather",weatherApiController.getTodayWeather());
	     mv.addObject("test", "hitest");
		 
		return mv;
		}
		
	
		
		 //fetch the admin page
		@GetMapping("/admin")     
		public ModelAndView admin() {	
		System.out.println("FrontPageController>admin");
	    //assign index.html file to mv
	    ModelAndView mv = new ModelAndView("admin.html");
		return mv;
		}
		
		 //fetch the user page
		@GetMapping("/user")
		public ModelAndView user() {
		System.out.println("FrontPageController>user");
		// assign index.html file to mv
		ModelAndView mv = new ModelAndView("user.html");
		return mv;
		}
		
		//Using Jedis(springboot Redis), set DnaSequence&its creation date&its length 
		//DnaSequence is acquired through RestService (from the Github Prject name 'consumeRestService')
		//This DnaSequence, will be analyzed by pcr system.
		
}
