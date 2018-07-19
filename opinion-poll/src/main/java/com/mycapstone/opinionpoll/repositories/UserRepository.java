//package com.mycapstone.opinionpoll.repositories;
//
//import com.mycapstone.opinionpoll.models.User;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@ComponentScan
//@Transactional
//public interface UserRepository extends CrudRepository<User, Integer> {
//
//    public User findByEmail(String email);
//    public User findOne(int id);
//}