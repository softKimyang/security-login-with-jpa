package com.example.jpasecurity.customer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerRequestDto {
    @NotNull
    @Size(min=1, max=275)
    private String firstName;
    @NotNull
    @Size(min=1, max=275)
    private String lastName;

}
