package com.ajkermenu.ajker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AjkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjkerApplication.class, args);
	}

}
