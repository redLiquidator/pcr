package com.pcr.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pcr.demo.entity.User;

@Repository
@Transactional
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;
	public long insert(User user) {
		//open transaction
		entityManager.persist(user);
		//close transaction
		return user.getId();
	};
}
