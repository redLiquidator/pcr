package com.pcr.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pcr.demo.redis.DnaSequence;
import com.pcr.demo.redis.DnaSequenceRepository;

@Controller
public class FrontPageController {

	    //fetch the front page
		@GetMapping("/front")     
		public ModelAndView front() {	
		System.out.println("FrontPageController>front");
	    //assign index.html file to mv
	    ModelAndView mv = new ModelAndView("front.html");
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
		
		//define a connectionFactory using Jedis client
		@Bean
		JedisConnectionFactory jedisConnectionFactory() {
		    return new JedisConnectionFactory();
		}
		
		//define a RedisTemplate using the jedisConnectionFactory. 
		//This will be used for quering data with a custom repository.
		//source https://www.baeldung.com/spring-data-redis-tutorial#maven-dependencies
		@Bean
		public RedisTemplate<String, Object> redisTemplate() {
		    RedisTemplate<String, Object> template = new RedisTemplate<>();
		    template.setConnectionFactory(jedisConnectionFactory());
		    return template;
		}
		
		@Autowired
		DnaSequenceRepository dnaSequenceRepository;
		
		public DnaSequence DnaRepositorySave() {
			DnaSequence dnaSequence = new DnaSequence(1,"CGAATAGCTAGGGATTTCTATA",22,new Date());
			System.out.println("dnaSequence"+dnaSequence);
			return dnaSequenceRepository.save(dnaSequence);
		}
		
		public DnaSequence DnaRepositoryRetrieveOneData() {
			DnaSequence retrievedDnaSequence = 
					dnaSequenceRepository.findById(1).get();
			return retrievedDnaSequence;
		}
		
		public List<DnaSequence> DnaRepositoryRetrieveList() {
			DnaSequence dnaSequence1 = new DnaSequence(2,"AATAGCTAGGGATTTCTATA",20,new Date());
			DnaSequence dnaSequence2 = new DnaSequence(3,"CGAATAGCTAGTCTATA",18,new Date());
				dnaSequenceRepository.save(dnaSequence1);
				dnaSequenceRepository.save(dnaSequence2);
				List<DnaSequence> seq = new ArrayList<>();
		 dnaSequenceRepository.findAll().forEach(seq::add);
		 return seq;
					
		}
		
		public DnaSequence DnaRepositoryUpdate() {
			DnaSequence dnaSequence = new DnaSequence(1,"CGAATAGCTAGGGA",14,new Date());
			dnaSequence.set("Richard Watson");
			return dnaSequenceRepository.save(dnaSequence);
		}
		
		public DnaSequence DnaRepositoryDelete() {
			return dnaSequenceRepository.deleteById(1);
			
		}			
}
