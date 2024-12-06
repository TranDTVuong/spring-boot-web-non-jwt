package com.javaweb.spring_boot_web_non_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.javaweb.spring_boot_web_non_jwt"})
public class SpringBootWebNonJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebNonJwtApplication.class, args);
	}

}
