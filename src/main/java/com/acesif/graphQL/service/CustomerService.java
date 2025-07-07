package com.acesif.graphQL.service;

import com.acesif.graphQL.dto.AgeRange;
import com.acesif.graphQL.entity.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.create(1, "skibidi", 20, "rizzland"),
            Customer.create(2, "ohio", 20, "china"),
            Customer.create(3, "chink", 20, "hitlarstation")
    );

    public Flux<Customer> customers() {
        return flux;
    }

    public Mono<Customer> getCustomerById(Integer id) {
        return flux.filter(c -> c.getId().equals(id)).next();
    }

    public Flux<Customer> getCustomersByMatchingNames(String name) {
        return flux.filter(c -> c.getName().contains(name));
    }

    public Flux<Customer> getCustomersByAgeRange(AgeRange ageRange) {
        return flux.filter(customer -> customer.getAge() > ageRange.getMinAge() && customer.getAge() < ageRange.getMaxAge());
    }
}
