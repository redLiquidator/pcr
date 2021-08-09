package com.pcr.demo.redis;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("DnaSequence")
public class DnaSequence implements Serializable{
	 
    private int dnaId;
    private String dnaSequence;
    private int dnaLength;
    private Date creationDate;
    
	public DnaSequence(int dnaId,String dnaSequence,int dnaLength,Date creationDate){
		this.dnaId=dnaId;
		this.dnaSequence=dnaSequence;
		this.dnaLength=dnaLength;
		this.creationDate=creationDate;	
	}
	
		public enum strandType { 
	        SINGLE, DOUBLE
	    }

}
