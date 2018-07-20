package com.mycapstone.opinionpoll.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycapstone.opinionpoll.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String email);

 }