package com.pcr.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcr.demo.entity.Primer;
import com.pcr.demo.entity.User;
//<Primer,Long> This repository deals with primer, the primary key is Long
public interface PrimerRepository extends JpaRepository<Primer,Integer>{

}
