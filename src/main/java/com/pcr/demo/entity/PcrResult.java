package com.pcr.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="pcrResult")
@Table(name="pcrResultTable")
public class PcrResult implements Serializable{
	public static final Long SerialVersionUID =1L;
	
	@Id
	private int resultId;
	
	private String seq;
	private String primerSeq;
	private String complementarySeq;
	private String start_t;
	private String c_primerSeq;
	private String product1_1;
	private String product1_2;
	private String product2_1;
	private String product2_2;
	private String product2;
	
	public PcrResult() {};
	
	public PcrResult(int resultId, String seq, String primerSeq, String complementarySeq, String start_t,
			String c_primerSeq, String product1_1, String product1_2, String product2_1, String product2_2,
			String product2) {
		super();
		this.resultId = resultId;
		this.seq = seq;
		this.primerSeq = primerSeq;
		this.complementarySeq = complementarySeq;
		this.start_t = start_t;
		this.c_primerSeq = c_primerSeq;
		this.product1_1 = product1_1;
		this.product1_2 = product1_2;
		this.product2_1 = product2_1;
		this.product2_2 = product2_2;
		this.product2 = product2;
	}

	@Override
	public String toString() {
		return "PcrResult [resultId=" + resultId + ", seq=" + seq + ", primerSeq=" + primerSeq + ", complementarySeq="
				+ complementarySeq + ", start_t=" + start_t + ", c_primerSeq=" + c_primerSeq + ", product1_1="
				+ product1_1 + ", product1_2=" + product1_2 + ", product2_1=" + product2_1 + ", product2_2="
				+ product2_2 + ", product2=" + product2 + "]";
	}
	
	
	
	
}