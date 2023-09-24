package com.example.jpasecurity.customer.web;

import com.example.jpasecurity.customer.domain.Customer;
import com.example.jpasecurity.customer.dto.CustomerRequestDto;
import com.example.jpasecurity.customer.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ModelAttribute
    CustomerRequestDto setUpForm() {
        return new CustomerRequestDto();
    }

    @GetMapping
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/customers/list";
    }

    @PostMapping(value = "create")
    String create(@Validated CustomerRequestDto requestDto, BindingResult result, Model model) {
        System.out.println("requestDto >>> " + requestDto.toString());
        if (result.hasErrors()) {
            return list(model);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(requestDto, customer);
        customerService.create(customer);
        return "redirect:/customers";
    }

    @PostMapping(value = "delete")
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

    @GetMapping(value = "edit", params = "form")
    String editForm(@RequestParam Integer id, CustomerRequestDto requestDto ) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, requestDto);
        return "customers/edit";
    }

    @PostMapping(value = "edit")
    String edit(@RequestParam Integer id, @Validated CustomerRequestDto requestDto, BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, requestDto);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(requestDto, customer);
        customer.setId(id);
        customerService.update(customer);
        return "redirect:/customers";
    }

    @GetMapping(value = "goToTop")
    String goToTop() {
        return "redirect:/customers";
    }

}
