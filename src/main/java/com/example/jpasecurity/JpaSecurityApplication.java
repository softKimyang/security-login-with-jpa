package com.example.jpasecurity;

import com.example.jpasecurity.customer.domain.Customer;
import com.example.jpasecurity.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaSecurityApplication implements CommandLineRunner {
	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		System.out.println("Hello spring boot");
		SpringApplication.run(JpaSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer newOne = customerRepository.save(
				new Customer(null, "NEW", "Customer" )
		);
		Customer customer = customerRepository.findOne(newOne.getId());
		if(customer == null){
			throw new Exception("Not found customer");
		}
		System.out.println(newOne + " is created");
		customerRepository.findAll()
				.forEach(System.out::println);
	}
}
