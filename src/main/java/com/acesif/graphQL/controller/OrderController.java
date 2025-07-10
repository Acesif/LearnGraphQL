package com.acesif.graphQL.controller;

import com.acesif.graphQL.entity.Customer;
import com.acesif.graphQL.entity.Order;
import com.acesif.graphQL.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // This is bad since this service gets invoked every time for each customer, so this scales badly
//    @SchemaMapping(typeName = "Customer")
//    public Flux<Order> orders(Customer customer, @Argument Integer limit) {
//        if (limit == null) {
//            limit = Integer.MAX_VALUE;
//        }
//        return orderService.getAllOrders(customer.getName()).take(limit);
//    }

    @BatchMapping(typeName = "Customer")
    public Flux<List<Order>> orders(List<Customer> customers) {
        return orderService.getOrders(
                customers.stream()
                        .map(Customer::getName)
                        .collect(Collectors.toList())
        );
    }
}
