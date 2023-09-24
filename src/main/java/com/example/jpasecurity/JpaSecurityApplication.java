package com.example.jpasecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaSecurityApplication {

	public static void main(String[] args) {
		System.out.println("Hello spring boot");
		SpringApplication.run(JpaSecurityApplication.class, args);
	}

}
