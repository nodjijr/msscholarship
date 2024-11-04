package com.github.nodji.msscholarship;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsscholarshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsscholarshipApplication.class, args);
	}

}
