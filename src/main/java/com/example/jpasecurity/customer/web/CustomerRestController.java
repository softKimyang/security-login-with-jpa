package com.example.jpasecurity.customer.web;

import com.example.jpasecurity.customer.domain.Customer;
import com.example.jpasecurity.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(value = "{id}")
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findOne(id);
        if (customer == null) {
            System.out.println(customer+ " is null");
        }
        return customer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomer(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping(value = "{id}")
    Customer putCustomer(@PathVariable Integer id,@RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }



}
