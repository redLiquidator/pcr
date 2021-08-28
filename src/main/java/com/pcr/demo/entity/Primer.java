package com.pcr.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "primerEntity")
@Table (name = "primer")
public class Primer {
	  @Id
	  @Column(name="id")
	  //@GeneratedValue(strategy=GenerationType.AUTO)
	  //primary key
	  private long id;
	  @Column(name="name")
	  private String name;
	  @Column(name="sequence")
	  private String sequence;
	  @Column(name="creation_date")
	  private Date creation_date;
	  @Column(name="created_by")
	  private String created_by;
	  
	public Primer() {

	} 
	
	public Primer(long id, String name, String sequence, Date creation_date, String created_by) {
		super();
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.creation_date = creation_date;
		this.created_by = created_by;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}			
}
