package com.pcr.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pcr.demo.entity.Primer;


//<Primer,Long> This repository deals with primer, the primary key is Long
public interface PrimerRepository extends JpaRepository<Primer,Long>{
	//find primer which contains the three bases ex.AAC, ACA, CCT, CTG
	//jpql vs native query(sql)
	//in below, pr is an aliase of primerEntity
	//1 means the first parameter
	//@Query("SELECT pr from primerEntity pr where pr.sequence like %?1%")
	@Query("SELECT pr from primerEntity pr where pr.sequence = '5-AGG-3 '")
	public List<Primer> findBySubSequence(String primerSeq);
}
