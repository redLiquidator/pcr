package com.pcr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pcr.demo.entity.DnaSequence;

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
	
	private static String getDnaSequence_url = "http://localhost:8088/dna/v1/dnaSequence/";
	
	//ajax call from front.html
	@RequestMapping(method = RequestMethod.GET, path = "/prep1") 
	public DnaSequence getDnaSequence(@RequestParam final int dnaLength) {
		System.out.println("prep1");
		//get dna sequence by its length through restTemplate 
		//from consumeRestService project	
		RestTemplate restTemplate = new RestTemplate();  //without this, RestTemplate null error occurs
		DnaSequence dnaSequence =restTemplate.getForObject(getDnaSequence_url+dnaLength,DnaSequence.class);
	
		return dnaSequence;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/test") 
	public String test(@RequestParam int dnaLength) {
		System.out.println("test===");
		System.out.println(dnaLength);
	
		return "testvvv";
	}
	
}
