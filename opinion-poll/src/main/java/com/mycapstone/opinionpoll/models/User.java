package com.mycapstone.opinionpoll.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
 	private String pwHash;
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@NotNull
	private String email;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	  
 

	private static String hashPassword(String password) {
		return encoder.encode(password);
	}

	public boolean isMatchingPassword(String password) {
		return encoder.matches(password, pwHash);
	}
 

}