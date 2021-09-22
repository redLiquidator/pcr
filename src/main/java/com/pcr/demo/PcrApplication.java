package com.pcr.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.pcr.demo.model.User;

//run redis-server.exe first
@SpringBootApplication
public class PcrApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PcrApplication.class, args);
	}

}
