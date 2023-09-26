package com.pcr.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pcr.demo.entity.PcrResult;

@RestController
public class FrontPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(FrontPageController.class);

	@Autowired
	private RedisTemplate redisTemplate;
	
	public static final String KEY = "PCR_Result";

	    //fetch the front page
		@GetMapping("/front")     
		public ModelAndView front() throws JsonProcessingException {	
			logger.info("FrontPageController>front");
			  
			  //get user info from spring security 
			  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
			  UserDetails userDetails = (UserDetails)principal; 
			  String username = ((UserDetails) principal).getUsername(); 
			  String password = ((UserDetails) principal).getPassword();
			  logger.info("username** "+username);
			  logger.info("password** "+password);

			  
			
		      //assign index.html file to mv
		      ModelAndView mv = new ModelAndView("front.html");
		    
		      WeatherApiController weatherApiController = new WeatherApiController();
		      Object todayWeather = weatherApiController.getTodayWeather();  //todayWeather is linkedHashMap
		      logger.info("before data transform: "+todayWeather);
		      
		      //ObjectMapper mapper = new ObjectMapper();
		      //String json = mapper.writeValueAsString(todayWeather); // (jackson) object->json this json doesn't work in this case
		      //System.out.println("after data transform: "+ json.getClass().getSimpleName()); 
		      mv.addObject("username", username);
		      mv.addObject("todayWeather",todayWeather);
		      mv.addObject("test", "hitest");
	
		     return mv;
		}

		//fetch the admin page
		@GetMapping("/admin")     
		public ModelAndView admin() {	
			logger.info("FrontPageController>admin");
		    //assign index.html file to mv
		    ModelAndView mv = new ModelAndView("admin.html");
			return mv;
		}
		
		//fetch the user page
		@GetMapping("/user")
		public ModelAndView user() {
			logger.info("FrontPageController>user");
			
			//get user's pcr execution result
			System.out.println("redisTemplate.opsForHash().values(KEY)"); 
			//List<PcrResult> pcrResult = redisTemplate.opsForHash().values(KEY); 
			//System.out.println(pcrResult.get(0));
			ModelAndView mv = new ModelAndView("user.html");
			//mv.addObject("test", pcrResult);
			return mv;
		}
		

			
		//Using Jedis(springboot Redis), set DnaSequence&its creation date&its length 
		//DnaSequence is acquired through RestService (from the Github Prject name 'consumeRestService')
		//This DnaSequence, will be analyzed by pcr system.
		
}
