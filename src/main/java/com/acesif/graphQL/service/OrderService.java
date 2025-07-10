package com.acesif.graphQL.service;

import com.acesif.graphQL.entity.Order;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Service
@RequiredArgsConstructor
public class OrderService {

    private Map<String, List<Order>> orders = Map.of(
            "skibidi", List.of(
                    Order.create(UUID.randomUUID(), "sdfgdsfbsd", 10, 10)
            ),
            "ohio", List.of(
                    Order.create(UUID.randomUUID(), "sdfgsdfg", 20, 20),
                    Order.create(UUID.randomUUID(), "4terggsd", 30, 30),
                    Order.create(UUID.randomUUID(), "fbdesvg", 30, 40)
            )
    );

// N + 1 problem
//    public Flux<Order> getAllOrders(String customerName) {
//        return Flux.fromIterable(orders.getOrDefault(customerName, List.of()));
//    }

    public Flux<List<Order>> getOrders(List<String> customerNames) {
        return Flux.fromIterable(customerNames).flatMap(name -> getOrder(name).defaultIfEmpty(List.of()));
    }

    private Mono<List<Order>> getOrder(String customerName) {
        return Mono.justOrEmpty(orders.get(customerName));
    }
}
