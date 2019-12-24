package com.example.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories(basePackages = "com.demo.repository")
@EntityScan(basePackages = "com.demo")
public class MyFirstSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootApplication.class, args);
	}

}
