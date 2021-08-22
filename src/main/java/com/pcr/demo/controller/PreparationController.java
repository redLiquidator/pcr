package com.pcr.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pcr.demo.entity.Dna;
import com.pcr.demo.entity.Primer;
import com.pcr.demo.service.PrimerRepository;


//the whole PCR process:
//preparation
//  1.create a sequence of dna. Enter the length of dna you want to get
//  2.search a primer whose sequence coincides with part of the dna you created.</p>
//  3.now the system brings polymerase enzyme & buffer
//pcr
//	1.denaturation 
//	2.annealing
//	3.extension
@RestController
public class PreparationController {
	
	private static final Logger logger = LoggerFactory.getLogger(PreparationController.class);
	
	private static String getDnaSequence_url = "http://localhost:8088/dna/v1/dnaSequence/";
	
	@Autowired
	PrimerRepository primerRepository;
	
	//ajax call from front.html
	@RequestMapping(method = RequestMethod.GET, path = "/prep1") 
	public Dna getDnaSequence(@RequestParam final int dnaLength) {
		System.out.println("prep1");
		//get dna sequence by its length through restTemplate 
		//from consumeRestService project	
		RestTemplate restTemplate = new RestTemplate();  //without this, RestTemplate null error occurs
		Dna dnaSequence =restTemplate.getForObject(getDnaSequence_url+dnaLength,Dna.class);
	
		return dnaSequence;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/primerSearch")
	public Optional<Primer> getPrimer(@RequestParam final String primerSequence) {
		System.out.println("PreparationController>getPrimer primerSequence is : "+primerSequence);
	      Primer primer = new Primer();	
	      System.out.println("primerRepository.findAll()");


	     //List<Primer> primerList = primerRepository.findAll();
	     //for(Primer pr: primerList) {
	    //	 System.out.println(pr.getId());
	     //}

		 Optional<Primer> userWithIdOne = primerRepository.findById(1); 
		 logger.info("primer is retrieved :  " + userWithIdOne);
		  
		 return userWithIdOne;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/test") 
	public String test(@RequestParam int dnaLength) {
		System.out.println("test===");
		System.out.println(dnaLength);
	
		return "testvvv";
	}
	
}
