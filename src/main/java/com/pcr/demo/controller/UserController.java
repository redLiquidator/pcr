package com.pcr.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcr.demo.model.User;
// run redis server first
@RestController
public class UserController {
	public static final String USER = "USER";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@GetMapping
	@RequestMapping("/save")
	public String saveUser(){
		redisTemplate.opsForHash().put("USER","1",new User(1,"Benjamin","developer",3));
		return "succeed";
	}
	
	@GetMapping
	@RequestMapping("/userList")
	public List<User> userList(){
		return redisTemplate.opsForHash().values(USER);
	}
	
	
	
	
	
}
