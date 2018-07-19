package com.mycapstone.opinionpoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.mycapstone.opinionpoll" })
@ComponentScan(basePackages = {"com.mycapstone.opinionpoll.controllers",
        "com.mycapstone.opinionpoll.services"})
@EntityScan("com.mycapstone.opinionpoll.entities")
@EnableJpaRepositories("com.mycapstone.opinionpoll.repositories")
public class OpinionPollApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpinionPollApplication.class, args);
	}
}
