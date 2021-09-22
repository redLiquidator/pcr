package com.pcr.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="user")
@Table(name="usersTable")
public class User implements Serializable {
	public static final Long SerialVersionUID =1L;
	
	@Id
	private int userId;
	
	private String name;
	private String profession;
	private int instaFollowers;
	
	public User(int userId, String name, String profession, int instaFollowers) {
		super();
		this.userId = userId;
		this.name = name;
		this.profession = profession;
		this.instaFollowers = instaFollowers;
	}
	
	
}
