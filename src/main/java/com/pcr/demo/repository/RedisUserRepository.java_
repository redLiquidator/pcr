package com.pcr.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.pcr.demo.model.User;

@Repository
public class RedisUserRepository {
	public static final String USER = "USER";
	@Autowired
	private UserRepository userRepository;
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;
	
	public RedisUserRepository(RedisTemplate redisTemplate) {
		this.redisTemplate =redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash();
	}
	
	public void save(User user) {
		userRepository.save(user);
		System.out.println(user.getUserId());
		hashOperations.put(USER,user.getUserId(),user);
		
	}
	
	public List<User> findAll(){
		return hashOperations.values(USER);
	}
	
	public User findById(int id) {
		return (User)hashOperations.get(USER,id);
	}
	
	public void update(User user) {
		userRepository.save(user);
		save(user);
	}
	
	public void delete(int id) {
		userRepository.delete(findById(id));
		hashOperations.delete(USER,String.valueOf(id));
	}	
}
