package com.pcr.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pcr.demo.UserRepositoryCommandLineRunner;
import com.pcr.demo.entity.Dna;
import com.pcr.demo.entity.User;
import com.pcr.demo.service.UserRepository;

@RestController
public class FrontPageController {
	
	private static final Logger log = LoggerFactory.getLogger(FrontPageController.class);

	@Autowired
	private UserRepository userRepository;
	
	    //fetch the front page
		@GetMapping("/front")     
		public ModelAndView front() throws JsonProcessingException {	
			  System.out.println("FrontPageController>front");
			
		      //assign index.html file to mv
		      ModelAndView mv = new ModelAndView("front.html");
		    
		      WeatherApiController weatherApiController = new WeatherApiController();
		      Object todayWeather = weatherApiController.getTodayWeather();  //todayWeather is linkedHashMap
		      System.out.println("before data transform: "+todayWeather);
		      
		      //ObjectMapper mapper = new ObjectMapper();
		      //String json = mapper.writeValueAsString(todayWeather); // (jackson) object->json this json doesn't work in this case
		      //System.out.println("after data transform: "+ json.getClass().getSimpleName()); 
		      
		      mv.addObject("todayWeather",todayWeather);
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
