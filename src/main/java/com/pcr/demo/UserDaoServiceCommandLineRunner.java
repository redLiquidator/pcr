package com.pcr.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pcr.demo.entity.User;
import com.pcr.demo.service.UserRepository;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//User user = new User("trump","ADMIN");
		//userRepository.save(user);
		//User user1 = new User("bush","USER");
		//userRepository.save(user1);
		//log.info("new user is created: "+user);
		//log.info("new user is created: "+user1);
		//Optional<User> setWitIdOne = userRepository.findById(1L); 
		//log.info("user is retrieved: "+setWitIdOne);
		
		//List<User> users = userRepository.findAll();
		//log.info("all users : "+users);
		
		//userRepository.save(entity); //insert &update
		
	}
	
}
