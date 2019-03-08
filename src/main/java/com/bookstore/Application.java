package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.bookstore"})
@EnableJpaRepositories(basePackages="com.bookstore.repositories")
@EntityScan(basePackages="com.bookstore.entities")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
