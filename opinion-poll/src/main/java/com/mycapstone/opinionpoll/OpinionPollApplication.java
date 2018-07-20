package com.mycapstone.opinionpoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.mycapstone.opinionpoll" })
public class OpinionPollApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpinionPollApplication.class, args);
	}
}
