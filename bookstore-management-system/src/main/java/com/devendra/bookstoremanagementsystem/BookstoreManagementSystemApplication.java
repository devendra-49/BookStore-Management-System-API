package com.devendra.bookstoremanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class BookstoreManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreManagementSystemApplication.class, args);
	}

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public OpenAPI getOpenApi() {
//		return new OpenAPI();
//	} 

}