package com.mycapstone.opinionpoll.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {

	@Id
	@GeneratedValue
    private int id;
	
    private String title;
    
    private String body;
    
    @ManyToOne
    private User user;
    
    private Date date = new Date();
    
    @ManyToOne
    private Category category;
 
}