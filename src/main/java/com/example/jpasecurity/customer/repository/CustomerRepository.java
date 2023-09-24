package com.example.jpasecurity.customer.repository;

import com.example.jpasecurity.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findOne(Integer id);
}
