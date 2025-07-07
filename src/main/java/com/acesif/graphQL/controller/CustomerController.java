package com.acesif.graphQL.controller;

import com.acesif.graphQL.dto.AgeRange;
import com.acesif.graphQL.entity.Customer;
import com.acesif.graphQL.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @QueryMapping
    public Flux<Customer> getCustomers() {
        return customerService.customers();
    }

    @QueryMapping
    public Mono<Customer> getCustomerById(@Argument Integer id) {
        return customerService.getCustomerById(id);
    }

    @QueryMapping
    public Flux<Customer> getCustomersByMatchingName(@Argument String name) {
        return customerService.getCustomersByMatchingNames(name);
    }

    @QueryMapping
    public Flux<Customer> getCustomersByAgeRange(@Argument AgeRange filter) {
        return customerService.getCustomersByAgeRange(filter);
    }
}
