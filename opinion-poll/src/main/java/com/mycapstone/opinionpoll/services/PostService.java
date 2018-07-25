package com.mycapstone.opinionpoll.services;

 import com.mycapstone.opinionpoll.models.Query;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PostService {

	 List<Query> findAll();
	    List<Query> findLatest5();
	    Query findById(int id);
	    Query create(Query query);
	    Query edit(Query query);
	    void deleteById(int id);
}