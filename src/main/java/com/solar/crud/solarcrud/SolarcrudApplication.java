package com.solar.crud.solarcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
public class SolarcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolarcrudApplication.class, args);
	}

}
