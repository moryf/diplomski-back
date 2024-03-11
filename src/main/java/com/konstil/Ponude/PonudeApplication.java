package com.konstil.Ponude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@AutoConfiguration
public class PonudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PonudeApplication.class, args);
	}

}
