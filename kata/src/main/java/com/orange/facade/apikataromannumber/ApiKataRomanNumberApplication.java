package com.orange.facade.apikataromannumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={
		"com.orange.facade.apikataromannumber"
})
public class ApiKataRomanNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiKataRomanNumberApplication.class, args);
	}

}
