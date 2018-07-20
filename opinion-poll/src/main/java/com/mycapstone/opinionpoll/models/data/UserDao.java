package com.mycapstone.opinionpoll.models.data;

import com.mycapstone.opinionpoll.models.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@ComponentScan({"com.mycapstone.opinionpoll.services"})
@EntityScan("com.mycapstone.opinionpoll.domain")
@EnableJpaRepositories("com.mycapstone.opinionpoll.repository")
public interface UserDao extends CrudRepository<User, Integer> {

    User findByEmail(String email);

 }
