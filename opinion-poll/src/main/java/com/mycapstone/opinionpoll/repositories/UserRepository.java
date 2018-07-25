package com.mycapstone.opinionpoll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycapstone.opinionpoll.models.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

 }