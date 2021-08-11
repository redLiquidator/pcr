package com.pcr.demo.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.pcr.demo.model.Student;

//actual redis database works done here
@Service
public class StudentService implements StudentRepository{

	private static final String TABLE_NAME = "Student";
	private RedisTemplate <String,Object> redisTemplate;
	private HashOperations<String, Long, Student> hashOperations;
	
	@Autowired
	public StudentService(RedisTemplate<String,Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	} 
	
	@PostConstruct
	private void initializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(Student student) {
		hashOperations.put(TABLE_NAME,student.getId(),student);	
	}

	@Override
	public Student find(Long id) {
		return hashOperations.get(TABLE_NAME,id);
	}

}
