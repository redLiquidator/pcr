package com.pcr.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pcr.demo.entity.User;
import com.pcr.demo.service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

	@Autowired
	private UserDAOService UserDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("trump","ADMIN");
		long insert = UserDaoService.insert(user); //user info is stored into user entity through CommandLineRunner
		log.info("new user is created:  "+insert+ " " + user);
	}
	
}
