package com.pcr.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcr.demo.entity.User;

//<User,Long> This repository deals with user, the primary key is Long
public interface UserRepository extends JpaRepository<User,Long>{

}
