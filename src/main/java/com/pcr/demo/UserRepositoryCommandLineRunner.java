package com.pcr.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pcr.demo.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 * User user = new User("pkh","ADMIN"); userRepository.save(user); //insert or
		 * update log.info("new user is created: " + user); Optional<User> userWithIdOne
		 * = userRepository.findById(1L); log.info("user is retrieved : " +
		 * userWithIdOne);
		 * 
		 * List<User> users = userRepository.findAll();
		 * log.info("user list is retrieved : " + users);
		 */	
	}	
}
