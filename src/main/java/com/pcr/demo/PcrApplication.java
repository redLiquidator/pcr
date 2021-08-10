package com.pcr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //turn on redis cashing
public class PcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcrApplication.class, args);
	}

}
