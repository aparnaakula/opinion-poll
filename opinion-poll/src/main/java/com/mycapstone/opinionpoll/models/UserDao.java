//package com.mycapstone.opinionpoll.models;
//
//import com.mycapstone.opinionpoll.models.User;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Transactional
//@Repository
//@ComponentScan({"com.delivery.request"})
//@ComponentScan({"com.repository.services"})
//@EntityScan("com.delivery.domain")
//@EnableJpaRepositories("com.delivery.repository")
//public interface UserDao extends CrudRepository<User, Integer> {
//
//    User findByEmail(String email);
//
//    User findOne(int id);
//}
