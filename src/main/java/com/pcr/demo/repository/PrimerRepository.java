package com.pcr.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pcr.demo.entity.Primer;


//<Primer,Long> This repository deals with primer, the primary key is Long
@Repository
public interface PrimerRepository extends JpaRepository<Primer,Long>{
	//find primer which contains the three bases ex.AAC, ACA, CCT, CTG
	//jpql vs native query(sql)
	//in below, pr is an aliase of primerEntity
	//1 means the first parameter
	//u.username LIKE CONCAT('%',:username,'%')")
	//@Query("SELECT pr from primerEntity pr where pr.sequence like '%CGA%'")
	//@Query("SELECT pr from primerEntity pr where pr.sequence like '%:ps%'")
	@Query("SELECT pr from primerEntity pr where pr.sequence like concat('%',:ps,'%')")
	public List<Primer> findBySubSequence(@Param("ps") String primerSeq);

	
}
